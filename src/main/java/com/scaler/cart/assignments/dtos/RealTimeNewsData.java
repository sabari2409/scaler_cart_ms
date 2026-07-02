package com.scaler.cart.assignments.dtos;

import com.scaler.cart.assignments.models.News;
import lombok.Data;

import java.util.List;

@Data
public class RealTimeNewsData {
    private List<News> news;
}