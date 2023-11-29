package com.greg.middleware.api;

import com.greg.middleware.core.GenericApiMiddleware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonApiController {
    private final GenericApiMiddleware apiMiddleware;

    public PokemonApiController(GenericApiMiddleware apiMiddleware) {
        this.apiMiddleware = apiMiddleware;
    }

    @GetMapping("/ditto")
    public String getPokemonData() {
        String pokemonEndPoint = "pokemon/ditto";
        return apiMiddleware.fetchDataFromApi(pokemonEndPoint);
    }
}
