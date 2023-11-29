package com.greg.middleware.core;

import org.springframework.stereotype.Component;

@Component
public class GenericApiMiddleware {
    private final ApiClient apiClient;

    public GenericApiMiddleware(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public String fetchDataFromApi(String endpoint) {
        return apiClient.fetchData(endpoint);
    }
}
