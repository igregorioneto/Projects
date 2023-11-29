package com.greg.middleware.core;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GenericApiMiddleware implements ApiClient {
    private final RestTemplate restTemplate;

    public GenericApiMiddleware(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String fetchData(String url) {
        return restTemplate.getForObject(url, String.class);
    }
}
