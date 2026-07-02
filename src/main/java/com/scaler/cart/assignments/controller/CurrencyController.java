package com.scaler.cart.assignments.controller;

import com.scaler.cart.assignments.models.News;
import com.scaler.cart.assignments.services.ICurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private ICurrencyService currencyService;

    @GetMapping("conversionNews")
    public List<News> getCurrencyNews(@RequestParam("from_symbol") String from,
                                      @RequestParam("to_symbol") String to) {
        return this.currencyService.getCurrencyNews(from, to);
    }
}
