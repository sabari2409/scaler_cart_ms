You also need to add implementation in Order createOrder(Map<Long,Long> itemQuantityMap, Long customerId) throws ShortInventoryException method present in
OrderService as per rules:

1. You are provided with Map itemQuantityMap, where key denotes itemId and value denotes quantity of that item which need to be ordered.
2. Using this map, you need to construct ItemDetails and persist into DB.
3. For each item, you also need to update Inventory based on quantity ordered. If count in Inventory is less than Quantity Ordered,
   you need to throw ShortInventoryException with Message - "Ordered Quantity is not Available".
4. The total cost of Order will be calculated by adding (item.price * quantity).
5. You also need to create OrderStateTimeMapping for this order and persist in DB.
6. You are provided with customerId, based on that populate Customer field In Order and persist in DB.
7. Whatever repos you need, are already provided.


You also need to add an API for creation of Order which will take Body in form of CreateOrderRequestDto and return created Order.Also
add ExceptionHandler for ShortInventoryException which will return status code 500 and exception message in Response Body.

You may need to define Loading Type(Fetch-Type) at some places to make CreateOrder method works properly.

You need not to do anything in dtos , exceptions and repos package. Just refer them for your understanding.


Inventory (id, item_id, count, orderingCost, stockOutCost)
-----------------------------------------------------------------
id = 23, item_id = 11, count = 10, orderingCost = 1000, stockOutCost = 5000
id = 45, item_id = 13, count = 5, orderingCost = 1300, stockOutCost = 1500
     |
     | 1:1
     |
     Item

Order (id, customer_id, totalCost,OrderStateTimeMapping (mapper field))                             OrderStateTimeMapping (id, order_id, date, orderState)
--------------------------------------------------------------------------------------------        ------------------------------------------------------------
id = 41, customer_id = C1, totalCost = 60000                                                        id = 51, order_id = 41, date = 14-07-2026, orderState = PENDING
    |                                                                                               id = 52, order_id = 41, date = 14-07-2026, orderState = CONFIRMED
    |  1: M                                                                                         ID = 53, ORDER_ID = 41, date = 14-07-2026, orderState = FULFILLED
    |
    |
    ItemDetail (id, item_id, quantity, order_id)
    ---------------------------------------------
    id = 31, item_id = 11, quantity = 3, order_id = 41, total_price = 20000 * 3 = 60000 (not in column, our own)
    id = 32, item_id = 13, quantity = 1, order_id = 41, total_price = 34000 * 1 = 34000 (not in column, our own)
        |
        | 1:1
        |
        Item (id, title, description, imageUrl, price, isPremium, inventory_id)
        --------------------------------------------------------------------------
        id = 11, title = "One plus Nord 5E", description = "One Plus", imageUrl="", price=20000, isPremium = false, inventory_id = 23
        id = 13, title = "Samsung Galaxy", description ="Galaxy", imageUrl="", price = 34000, isPremium = false, inventory_id = 45


SQL Queries:
-------------------
insert into customer(email,name,password) values( 'sabari@gmail.com', 'sabari', 'admin');

select * from customer;

select * from item;

insert into item(is_premium,price,description,title) values(false, 2000, 'Android phone', 'One plus nord');

select * from inventory;
insert into inventory(count, ordering_cost,stock_out_cost, item_id) values(5,500,5000,1);

select * from orders;
select * from order_state_time_mapping;