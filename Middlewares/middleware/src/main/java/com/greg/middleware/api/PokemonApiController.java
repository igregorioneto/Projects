package com.greg.middleware.api;

import com.greg.middleware.clients.PokemonApiClient;
import com.greg.middleware.core.GenericApiMiddleware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonApiController {
    private final PokemonApiClient pokemonApiClient;

    public PokemonApiController(PokemonApiClient pokemonApiClient) {
        this.pokemonApiClient = pokemonApiClient;
    }

    @GetMapping("/ditto")
    public String getPokemonData() {
        String pokemonEndPoint = "pokemon/ditto";
        return pokemonApiClient.fetchDataFromApi(pokemonEndPoint);
    }
}
