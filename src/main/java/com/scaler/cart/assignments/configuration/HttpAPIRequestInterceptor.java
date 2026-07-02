package com.scaler.cart.assignments.configuration;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class HttpAPIRequestInterceptor implements ClientHttpRequestInterceptor {

    private final ApiProperties apiProperties;

    public HttpAPIRequestInterceptor(ApiProperties apiProperties) {
        this.apiProperties = apiProperties;
    }


    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        System.out.println("Interceptor called");
        String key = this.apiProperties.getKey();
        String value = this.apiProperties.getValue();
        System.out.println("API Key -->" + key);
        System.out.println("API value --> " + value);
        request.getHeaders().set(key, value);
        return execution.execute(request, body);
    }
}
