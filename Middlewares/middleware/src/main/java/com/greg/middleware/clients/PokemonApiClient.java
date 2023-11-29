package com.greg.middleware.clients;

import com.greg.middleware.core.ApiClient;
import com.greg.middleware.core.GenericApiMiddleware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokemonApiClient {

    private final GenericApiMiddleware apiMiddleware;
    private String url;

    public PokemonApiClient(GenericApiMiddleware apiMiddleware) {
        this.apiMiddleware = apiMiddleware;
        url = "https://pokeapi.co/api/v2/";;
    }

    public String fetchDataFromApi(String endpoint) {
        return apiMiddleware.fetchData(url + endpoint);
    }
}
