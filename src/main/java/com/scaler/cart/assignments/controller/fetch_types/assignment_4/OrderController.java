package com.scaler.cart.assignments.controller.fetch_types.assignment_4;

import com.scaler.cart.assignments.dtos.fetch_types.assignment_4.CreateOrderRequestDto;
import com.scaler.cart.assignments.exceptions.fetch_types.assignment_4.ShortInventoryException;
import com.scaler.cart.assignments.exceptions.fetch_types.assignment_5.OrderNotFoundException;
import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.CancelOrderRequestDto;
import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.Order;
import com.scaler.cart.assignments.services.fetch_types_assignments.assignment_4.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping
    public Order create(@RequestBody CreateOrderRequestDto requestDto) throws ShortInventoryException {
        return this.orderService.createOrder(requestDto.getItemQuantityMap(), requestDto.getCustomerId());
    }

    @DeleteMapping
    public Boolean cancelOrder(@RequestBody CancelOrderRequestDto requestDto) throws OrderNotFoundException {
        return this.orderService.cancelOrder(requestDto.getOrderId());
    }

}