package com.scaler.cart.assignments.services;

import com.scaler.cart.assignments.models.other_assignments.AmazonProduct;

import java.util.List;

public interface IProductService {
    List<AmazonProduct> getProductByName(String name);

    List<AmazonProduct> getProductByCategoryId(String categoryId);
}
