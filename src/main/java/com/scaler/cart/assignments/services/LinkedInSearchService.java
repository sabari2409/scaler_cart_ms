package com.scaler.cart.assignments.services;


import com.scaler.cart.assignments.dtos.LinkedInSearchRequest;
import com.scaler.cart.assignments.dtos.LinkedInSearchResult;
import com.scaler.cart.assignments.models.LinkedInSearchItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class LinkedInSearchService implements ISearchService {

    private final String BASE_URL = "https://linkedin-data-api.p.rapidapi.com/";
    private final String headerValue = "2b7d719a6emshc865030ef65fe01p1d8b17jsncbf82267fa49";
    private final String headerName = "X-RapidAPI-Key";


    @Autowired
    RestTemplateBuilder restTemplateBuilder;

    //Take help from - https://binarycoders.wordpress.com/2020/10/04/add-a-header-to-spring-resttemplate/#:~:text=add(%20new%20HeaderRequestInterceptor(%20%22X,setInterceptors(interceptors)%3B
    public List<LinkedInSearchItem> searchPeople(LinkedInSearchRequest linkedInSearchRequest) {
        //Add your implementation here
        RestTemplate restTemplate = this.restTemplateBuilder.build();
        List<ClientHttpRequestInterceptor> interceptor = new ArrayList<ClientHttpRequestInterceptor>();
        interceptor.add(new HeaderRequestInterceptor(headerName, headerValue));
        restTemplate.setInterceptors(interceptor);

        ResponseEntity<LinkedInSearchResult> searchResultList =
                restTemplate.postForEntity(this.BASE_URL + "search-people-by-url", linkedInSearchRequest, LinkedInSearchResult.class);
        if (!searchResultList.hasBody()) {
            throw new RuntimeException("Error in search");
        }
        if (searchResultList.getBody() == null) {
            throw new NullPointerException("Search result is null");
        }
        LinkedInSearchResult linkedInSearchResult = searchResultList.getBody();
        return linkedInSearchResult.getData().getItems();
    }
}
