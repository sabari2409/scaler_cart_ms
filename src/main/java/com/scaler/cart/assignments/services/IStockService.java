package com.scaler.cart.assignments.services;

import com.scaler.cart.assignments.models.other_assignments.CashFlow;
import com.scaler.cart.assignments.models.other_assignments.News;

import java.util.List;

public interface IStockService {
    List<News> getStockNews(String symbol);

    List<CashFlow> getCompanyCashFlow(String symbol);
}