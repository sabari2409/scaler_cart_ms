package com.scaler.cart.assignments.dtos.fetch_types.assignment_4;

import lombok.Data;

import java.util.Map;

@Data
public class CreateOrderRequestDto {
    private Map<Long,Long> itemQuantityMap;
    private Long customerId;
}
