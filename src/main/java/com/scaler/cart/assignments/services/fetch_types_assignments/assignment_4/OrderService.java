package com.scaler.cart.assignments.services.fetch_types_assignments.assignment_4;

import com.scaler.cart.assignments.exceptions.fetch_types.assignment_4.ShortInventoryException;
import com.scaler.cart.assignments.exceptions.fetch_types.assignment_5.OrderNotFoundException;
import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.*;
import com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_4.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemDetailRepo itemDetailRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderStateTimeMappingRepo orderStateTimeMappingRepo;

    public Order createOrder(Map<Long, Long> itemQuantityMap, Long customerId) throws ShortInventoryException {
        // Get the customer details by customer id
        Optional<Customer> customerRepoResponse = this.customerRepo.findById(customerId);
        List<Item> itemsList = new ArrayList<>();
        Map<Long, Item> itemsMap = new HashMap<>();
        if (customerRepoResponse.isEmpty())
            throw new RuntimeException("Customer details is not available. Unable to place an order");
        Customer customerEntity = customerRepoResponse.get();
        double totalCost = 0.0;

        /**
         * To create an order we need
         *  1. customer_id(customer entity),
         *  2. List<ItemDetails> items,
         *  3. totalCost,
         *  4. List<OrderStateTimeMapping> orderTimeline
         *
         *  Below input we will get it:
         *  itemQuantityMap =  { 101: 5, 345: 10, 89: 2} - itemQuantityMap -> itemId (key), quantity(value) which needs to be ordered.
         *  customerId
         *
         */

        for (Map.Entry<Long, Long> entry : itemQuantityMap.entrySet()) {
            Long itemId = entry.getKey();
            Long purchaseQuantity = entry.getValue();

            // Get the items info from item repo
            Optional<Item> item = this.itemRepo.findById(itemId);
            if (item.isEmpty()) throw new RuntimeException("Item not present. Please create an item");
            itemsMap.put(itemId, item.get()); // Approach 2
//            itemsList.add(item.get()); - Approach 1

            // Get the inventory details based on itemId
            Optional<Inventory> inventoryDetails = this.inventoryRepo.findByItem(item.get());
            if (inventoryDetails.isEmpty())
                throw new RuntimeException("Inventory is not present. Please create an inventory for an item");

            // Validate inventory count > purchased quantity. Else throw error
            Double inventoryQuantity = inventoryDetails.get().getCount();
            if (inventoryQuantity < purchaseQuantity)
                throw new ShortInventoryException("Ordered Quantity is not Available");


            // Now based on the purchase quantity update inventory
            Double balanceQuantity = inventoryQuantity - purchaseQuantity;
            Inventory inventory = inventoryDetails.get();
            inventory.setCount(balanceQuantity);
            this.inventoryRepo.save(inventory);

            // Calculate the total cost
            Double itemPrice = item.get().getPrice();
            totalCost += purchaseQuantity * itemPrice;
            System.out.println("Total cost = " + totalCost);
        }


        // create order
        Order order = new Order();
        order.setCustomer(customerEntity);
        order.setTotalCost(totalCost);
        Order savedOrderDetails = this.orderRepo.save(order);

        // update the orderStatTimeMapping
        OrderStateTimeMapping orderStateTimeMapping = new OrderStateTimeMapping();
        orderStateTimeMapping.setOrderState(OrderState.CONFIRMED);
        orderStateTimeMapping.setOrder(savedOrderDetails);
        orderStateTimeMapping.setDate(new Date());
        this.orderStateTimeMappingRepo.save(orderStateTimeMapping);
        savedOrderDetails.setOrderTimeline(List.of(orderStateTimeMapping));

        List<ItemDetail> itemDetailList = new ArrayList<>();
        for (Map.Entry<Long, Long> entry : itemQuantityMap.entrySet()) {
            Long itemId = entry.getKey();
            Long purchaseQuantity = entry.getValue();

            // Below line no 112 is approach 1. Time complexity is high. So I have commented it out.
//            Set<Item> item = itemsList.stream().filter((d) -> Objects.equals(d.getId(), itemId)).collect(Collectors.toSet());

            // Approach 2: Using hashmap
            Item item = itemsMap.get(itemId);

            // Create ItemDetails entry based on items
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setItem(item);
            itemDetail.setQuantity(purchaseQuantity);
            itemDetail.setOrder(savedOrderDetails);
            this.itemDetailRepo.save(itemDetail);
            itemDetailList.add(itemDetail);
        }
        savedOrderDetails.setItems(itemDetailList);

        return savedOrderDetails;
    }


    /**
     * cancelOrder
     * @param orderId
     * @return
     * @throws OrderNotFoundException
     */
    public Boolean cancelOrder(Long orderId) throws OrderNotFoundException {
        // TODO: Get Order from DB based on OrderId, If order is not present, throw OrderNotFoundException with message - orderId is wrong
        Order orderDetails = this.orderRepo.findById(orderId).orElseThrow(() -> new OrderNotFoundException("orderId is wrong"));

        // TODO: Get ItemDetails saved in DB corresponding to that Order and delete them. After deleting the item details, update Inventory back
        List<ItemDetail> itemDetailList = this.itemDetailRepo.findByOrder(orderDetails);
        for (ItemDetail itemDetail : itemDetailList) {
            Optional<Inventory> inventoryDetails = this.inventoryRepo.findByItem(itemDetail.getItem());
            if (inventoryDetails.isEmpty())
                throw new RuntimeException("Inventory is not present. Unable to process this request");


            Double lastQuantity = Math.abs(inventoryDetails.get().getCount() + itemDetail.getQuantity());
            Inventory inventory = inventoryDetails.get();
            inventory.setCount(lastQuantity);
            this.inventoryRepo.save(inventory);
            this.itemDetailRepo.delete(itemDetail);
        }

        // TODO: Create OrderStateTimeMapping with cancelled order state for this Order and persist into DB.
        OrderStateTimeMapping orderStateTimeMapping = new OrderStateTimeMapping();
        orderStateTimeMapping.setDate(new Date());
        orderStateTimeMapping.setOrderState(OrderState.CANCELLED);
        orderStateTimeMapping.setOrder(orderDetails);
        this.orderStateTimeMappingRepo.save(orderStateTimeMapping);

        // TODO: Also get Customer who has cancelled the order and update it's OrderCancellationCount and persist into DB.
        Customer customer = orderDetails.getCustomer();
        Long newCancellationCount = customer.getOrderCancellationCount() + 1L;
        customer.setOrderCancellationCount(newCancellationCount);
        this.customerRepo.save(customer);
        return true;
    }
}