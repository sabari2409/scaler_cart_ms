package com.scaler.cart.assignments.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "api.headers.config")
@Data
public class ApiProperties {

    private String baseUrl;
    private String key;
    private String value;
}
