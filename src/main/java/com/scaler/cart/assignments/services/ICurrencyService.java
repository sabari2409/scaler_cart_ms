package com.scaler.cart.assignments.services;


import com.scaler.cart.assignments.models.other_assignments.News;

import java.util.List;

public interface ICurrencyService {
    List<News> getCurrencyNews(String fromCurrency, String toCurrency);
}