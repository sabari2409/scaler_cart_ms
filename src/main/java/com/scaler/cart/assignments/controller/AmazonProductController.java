package com.scaler.cart.assignments.controller;

import com.scaler.cart.assignments.models.other_assignments.AmazonProduct;
import com.scaler.cart.assignments.services.IProductService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/amazon")
public class AmazonProductController {

    @GetMapping("sample")
    public String printHello() {
        return "Hello world";
    }

    @Autowired
    private IProductService amazonProductService;

    //Add your APIs here.
    @GetMapping("search")
    public List<AmazonProduct> getProductsByName(@RequestParam("query") String searchQuery) {
        return this.amazonProductService.getProductByName(searchQuery);
    }

    @GetMapping("products-by-category")
    public List<AmazonProduct> getProductsByCategoryId(@RequestParam("categoryid") String categoryId) {
        System.out.println("categoryId -->" + categoryId);
        return this.amazonProductService.getProductByCategoryId(categoryId);
    }
}