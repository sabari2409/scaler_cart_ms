package com.scaler.cart.assignments.controller;

import com.scaler.cart.assignments.dtos.LinkedInSearchRequest;
import com.scaler.cart.assignments.models.LinkedInSearchItem;
import com.scaler.cart.assignments.services.ISearchService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/linkedInSearch")
public class LinkedInSearchController {

    @Autowired
    private ISearchService searchService;

    //Add your APIs here

    @PostMapping
    public List<LinkedInSearchItem> searchPeople(@RequestBody LinkedInSearchRequest request) {
        return this.searchService.searchPeople(request);
    }
}