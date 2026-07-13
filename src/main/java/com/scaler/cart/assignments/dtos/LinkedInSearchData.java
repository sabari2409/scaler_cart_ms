package com.scaler.cart.assignments.dtos;

import lombok.Data;
import com.scaler.cart.assignments.models.other_assignments.LinkedInSearchItem;

import java.util.List;

@Data
public class LinkedInSearchData {
    private List<LinkedInSearchItem> items;
}