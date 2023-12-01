package com.greg.middleware.clients;

import org.springframework.stereotype.Service;

/*
* Esta classe é um serviço no qual será tratado informações as chamadas da api pokemon
*
* @author Greg
* @version 1.0
* @since 2023-11-30
* */
@Service
public class PokemonService {

    /*
    * Método para realizar o tratamento do endpoint conforme o valor vindo da requisição
    *
    * @param PokemonRequest Classe com informações da requisição
    * @return String retorna o endpoint formatado
    * */
    public String endpoint(PokemonRequest pokemonRequest) {
        String endpoint = "pokemon";
        if (pokemonRequest != null) {
            if (pokemonRequest.name() != null) {
                endpoint += "/" + pokemonRequest.name();
            } else if (pokemonRequest.speciesName() != null) {
                endpoint = "pokemon-species/" + pokemonRequest.speciesName();
            } else if (pokemonRequest.typeId() != null) {
                endpoint = "type/" + pokemonRequest.typeId();
            } else if (pokemonRequest.abilityName() != null) {
                endpoint = "ability/" + pokemonRequest.abilityName();
            }
        }

        if (endpoint.equals("pokemon") && pokemonRequest.limit() != null) {
            endpoint += "?limit="+pokemonRequest.limit();
        }

        if (endpoint.contains("?limit=")) {
            int offset = pokemonRequest.offset() != null ? pokemonRequest.offset() : 0;
            endpoint += "&offset=" + offset;
        }

        return endpoint;
    }
}
