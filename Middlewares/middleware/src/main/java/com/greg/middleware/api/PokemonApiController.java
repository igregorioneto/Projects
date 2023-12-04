package com.greg.middleware.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.greg.middleware.clients.PokemonApiClient;
import com.greg.middleware.clients.PokemonRequest;
import com.greg.middleware.clients.PokemonService;
import jakarta.validation.Valid;
import org.owasp.encoder.Encode;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/*
* Controlador do endpoint da api pokemon
*
* @author Greg
* @version 1.0
* @since 2023-11-29
* */
@RestController
@RequestMapping("/pokemon")
public class PokemonApiController {
    private final PokemonApiClient pokemonApiClient;
    private final PokemonService pokemonService;

    public PokemonApiController(PokemonApiClient pokemonApiClient, PokemonService pokemonService) {
        this.pokemonApiClient = pokemonApiClient;
        this.pokemonService = pokemonService;
    }

    /*
    * Irá retornar a pesquisa desejada com base na requisição passada no PokemonRequest
    *
    * @param PokemonRequest parametros para a requisição
    * @return String retorno da requisição feita
    * */
    @PostMapping
    public JsonNode getPokemonData(@Valid @RequestBody PokemonRequest pokemonRequest) {
        String pokemonEndPoint = pokemonService.endpoint(pokemonRequest);
        String response = pokemonApiClient.fetchDataFromApi(pokemonEndPoint);
        try {
            return pokemonService.convertStringAndJson(response);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
