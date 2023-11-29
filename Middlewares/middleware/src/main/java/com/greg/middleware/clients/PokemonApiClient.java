package com.greg.middleware.clients;

import com.greg.middleware.core.ApiClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PokemonApiClient implements ApiClient {
    private final RestTemplate restTemplate;

    public PokemonApiClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String fetchData(String endpoint) {
        String url = "https://pokeapi.co/api/v2/" + endpoint;
        return restTemplate.getForObject(url, String.class);
    }
}
