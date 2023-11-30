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
            if (pokemonRequest.getName() != null) {
                endpoint += "/" + pokemonRequest.getName();
            } else if (pokemonRequest.getSpeciesName() != null) {
                endpoint = "pokemon-species/" + pokemonRequest.getSpeciesName();
            } else if (pokemonRequest.getTypeId() != null) {
                endpoint = "type/" + pokemonRequest.getTypeId();
            } else if (pokemonRequest.getAbilityName() != null) {
                endpoint = "ability/" + pokemonRequest.getAbilityName();
            }
        }

        if (endpoint.equals("pokemon") && pokemonRequest.getLimit() != null) {
            endpoint += "?limit="+pokemonRequest.getLimit();
        }

        if (endpoint.contains("?limit=")) {
            int offset = pokemonRequest.getOffset() != null ? pokemonRequest.getOffset() : 0;
            endpoint += "&offset=" + offset;
        }

        return endpoint;
    }
}
