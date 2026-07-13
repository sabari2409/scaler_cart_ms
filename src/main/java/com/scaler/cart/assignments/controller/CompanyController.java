package com.scaler.cart.assignments.controller;

import com.scaler.cart.assignments.models.other_assignments.CashFlow;
import com.scaler.cart.assignments.models.other_assignments.News;
import com.scaler.cart.assignments.services.IStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private IStockService companyService;

    @GetMapping("stockNews")
    public List<News> getStockNews(@RequestParam("symbol") String symbol) {
        return this.companyService.getStockNews(symbol);
    }

    @GetMapping("cashFlow")
    public List<CashFlow> getCompanyCashFlow(@RequestParam("symbol") String symbol) {
        return this.companyService.getCompanyCashFlow(symbol);
    }
}
