package com.scaler.cart.assignments.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {


    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder, HttpAPIRequestInterceptor httpAPIRequestInterceptor) {
        return restTemplateBuilder
                .additionalInterceptors(httpAPIRequestInterceptor)
                .build();

    }

}
