package com.scaler.cart.assignments.services;

import com.scaler.cart.assignments.dtos.RealTimeNewsData;
import com.scaler.cart.assignments.dtos.RealTimeNewsResult;
import com.scaler.cart.assignments.models.other_assignments.News;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class CurrencyNewsService implements ICurrencyService {

    private final String BASE_URL = "https://real-time-finance-data.p.rapidapi.com/";
    private final String headerValue = "2b7d719a6emshc865030ef65fe01p1d8b17jsncbf82267fa49";
    private final String headerName = "X-RapidAPI-Key";


    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public List<News> getCurrencyNews(String fromCurrency, String toCurrency) {
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        ResponseEntity<RealTimeNewsResult> responseEntity = restTemplate.exchange(
                this.BASE_URL + "currency-news?from_symbol={currency1}&to_symbol={currency2}",
                HttpMethod.GET,
                this.setHeaders(),
                RealTimeNewsResult.class,
                fromCurrency,
                toCurrency
        );
        if (!responseEntity.hasBody()) {
            throw new RuntimeException("Unable to get stock news data");
        }
        RealTimeNewsData realTimeCashFlowData = Objects.requireNonNull(responseEntity.getBody()).getData();
        return realTimeCashFlowData.getNews();
    }


    private HttpEntity<HttpHeaders> setHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(headerName, headerValue);
        HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(httpHeaders);
        return httpEntity;
    }
}