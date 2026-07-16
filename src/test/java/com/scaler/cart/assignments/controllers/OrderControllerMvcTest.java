package com.scaler.cart.assignments.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scaler.cart.assignments.controller.fetch_types.assignment_4.OrderController;
import com.scaler.cart.assignments.dtos.fetch_types.assignment_4.CreateOrderRequestDto;
import com.scaler.cart.assignments.exceptions.fetch_types.assignment_4.ShortInventoryException;
import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_4.Order;
import com.scaler.cart.assignments.services.fetch_types_assignments.assignment_4.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
public class OrderControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IOrderService orderService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCreateOrderSuccess() throws Exception {
        Long customerId = 1L;
        Long itemId = 1L;
        Long quantity = 2L;

        CreateOrderRequestDto createOrderRequestDto = new CreateOrderRequestDto();
        createOrderRequestDto.setCustomerId(customerId);
        createOrderRequestDto.setItemQuantityMap(Map.of(itemId, quantity));

        Order order = new Order();
        order.setId(1L);
        order.setTotalCost(20.0);

        when(orderService.createOrder(createOrderRequestDto.getItemQuantityMap(), createOrderRequestDto.getCustomerId()))
                .thenReturn(order);

        mockMvc.perform(post("/order")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(createOrderRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.totalCost").value(20.0));

        verify(orderService, times(1)).createOrder(createOrderRequestDto.getItemQuantityMap(), createOrderRequestDto.getCustomerId());
    }

    @Test
    void testCreateOrderShortInventoryException() throws Exception {
        Long customerId = 1L;
        Long itemId = 1L;
        Long quantity = 2L;

        CreateOrderRequestDto createOrderRequestDto = new CreateOrderRequestDto();
        createOrderRequestDto.setCustomerId(customerId);
        createOrderRequestDto.setItemQuantityMap(Map.of(itemId, quantity));

        when(orderService.createOrder(createOrderRequestDto.getItemQuantityMap(), createOrderRequestDto.getCustomerId()))
                .thenThrow(new ShortInventoryException("Ordered Quantity is not Available"));

        mockMvc.perform(post("/order")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(createOrderRequestDto)))
                .andExpect(status().isInternalServerError())
                .andExpect(content().string("Ordered Quantity is not Available"));

        verify(orderService, times(1)).createOrder(createOrderRequestDto.getItemQuantityMap(), createOrderRequestDto.getCustomerId());
    }
}