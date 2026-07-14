package com.scaler.cart.assignments.services.fetch_types_assignments.assignment_4;

import com.scaler.cart.assignments.exceptions.fetch_types.assignment_4.ShortInventoryException;
import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.*;
import com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_4.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.*;

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

            // Get the inventory details based on itemId
            Optional<Inventory> inventoryDetails = this.inventoryRepo.findByItem(item.get());
            if (inventoryDetails.isEmpty())
                throw new RuntimeException("Inventory is not present. Please create an inventory for an item");

            // Validate inventory count > purchased quantity. Else throw error
            Double inventoryQuantity = inventoryDetails.get().getCount();
            if (inventoryQuantity < purchaseQuantity)
                throw new ShortInventoryException("Ordered Quantity is not Available");

            // Create ItemDetails entry based on items
            ItemDetail itemDetail = new ItemDetail();
            itemDetail.setItem(item.get());
            itemDetail.setQuantity(purchaseQuantity);
            itemDetail.setOrder(null);
            this.itemDetailRepo.save(itemDetail);

            // Now based on the purchase quantity update inventory
            Double balanceQuantity = inventoryQuantity - purchaseQuantity;
            Inventory inventory = inventoryDetails.get();
            inventory.setCount(balanceQuantity);
            this.inventoryRepo.save(inventory);

            // Calculate the total cost
            Double itemPrice = itemDetail.getItem().getPrice();
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

        return order;
    }
}