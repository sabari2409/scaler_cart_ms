package com.scaler.cart.assignments.services;

import com.scaler.cart.assignments.configuration.ApiProperties;
import com.scaler.cart.assignments.dtos.AmazonProductDto;
import com.scaler.cart.assignments.models.other_assignments.AmazonProduct;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class AmazonProductService implements IProductService {

//    private final String BASE_URL = "https://real-time-amazon-data.p.rapidapi.com/";
//    private final String headerValue = "2b7d719a6emshc865030ef65fe01p1d8b17jsncbf82267fa49";
//    private final String headerName = "X-RapidAPI-Key";

//    @Autowired
//    RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApiProperties apiProperties;

    public List<AmazonProduct> getProductByName(String name) {
//        RestTemplate restTemplate = this.restTemplateBuilder.build();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set(headerName, headerValue);
//
//        HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(httpHeaders);

        ResponseEntity<AmazonProductDto> responseEntity =
                restTemplate.exchange(this.apiProperties.getBaseUrl() + "search?query={name}", HttpMethod.GET, HttpEntity.EMPTY, AmazonProductDto.class, name);

        if (!responseEntity.hasBody()) {
            throw new RuntimeException("Unable to get products by category Id");
        }
        return Objects.requireNonNull(responseEntity.getBody()).getData().getProducts();
    }

    public List<AmazonProduct> getProductByCategoryId(String categoryId) {
        System.out.println("Category Id -->" + categoryId);
//        RestTemplate restTemplate = this.restTemplateBuilder.build();
//        HttpHeaders httpHeaders = new HttpHeaders();
//        httpHeaders.set(headerName, headerValue);
//
//        HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(httpHeaders);

//        System.out.println("base url -->" + this.BASE_URL + "products-by-category?category_id={cid}");
        System.out.println("API Key -->" + this.apiProperties.getKey());
        System.out.println("API value --> " + this.apiProperties.getValue());
        ResponseEntity<AmazonProductDto> responseEntity =
                restTemplate
                        .exchange(this.apiProperties.getBaseUrl() + "products-by-category?category_id={cid}",
                                HttpMethod.GET,
                                HttpEntity.EMPTY,
                                AmazonProductDto.class,
                                categoryId);
        System.out.println("Response entity has body -->" + responseEntity);
        if (!responseEntity.hasBody()) {
            throw new RuntimeException("Unable to get products by category Id");
        }
        return Objects.requireNonNull(responseEntity.getBody()).getData().getProducts();
    }
}