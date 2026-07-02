package com.scaler.cart.assignments.dtos;

import com.scaler.cart.assignments.models.AmazonProduct;
import lombok.Data;

import java.util.List;

@Data
public class AmazonProductDataDto {
    private List<AmazonProduct> products;
}
