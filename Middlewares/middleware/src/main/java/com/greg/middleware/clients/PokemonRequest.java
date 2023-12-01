package com.greg.middleware.clients;


/*
* Record de filtro do endpoint
*
* @author Greg
* @version 1.0
* @since 2023-11-30
* */
public record PokemonRequest(
        String name,
        String speciesName,
        Integer typeId,
        String abilityName,
        Integer limit,
        Integer offset
) {
}
