package com.scaler.cart.assignments.services.fetch_types_assignments.assignment_4;


import com.scaler.cart.assignments.exceptions.fetch_types.assignment_4.ShortInventoryException;
import com.scaler.cart.assignments.exceptions.fetch_types.assignment_5.OrderNotFoundException;
import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.Order;

import java.util.Map;

public interface IOrderService {
    Order createOrder(Map<Long,Long> itemQuantityMap, Long customerId) throws ShortInventoryException;
    Boolean cancelOrder(Long orderId) throws OrderNotFoundException;
}
