package com.scaler.cart.assignments.services;

import com.scaler.cart.assignments.dtos.LinkedInSearchRequest;
import com.scaler.cart.assignments.models.LinkedInSearchItem;

import java.util.List;

public interface ISearchService {
    List<LinkedInSearchItem> searchPeople(LinkedInSearchRequest linkedInSearchRequest);
}