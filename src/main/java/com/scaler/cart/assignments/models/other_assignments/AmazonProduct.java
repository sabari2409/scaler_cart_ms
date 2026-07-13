package com.scaler.cart.assignments.models.other_assignments;

import lombok.Data;

@Data
public class AmazonProduct {
    private String product_title;
    private String product_price;
    private String product_photo;
    private Boolean is_prime;
    private String asin;
}