package com.greg.middleware.clients;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

/*
* Record de filtro do endpoint
*
* @author Greg
* @version 1.0
* @since 2023-11-30
* */
public record PokemonRequest(
        @Pattern(regexp = "[a-zA-Z0-9]+") String name,
        @Pattern(regexp = "[a-zA-Z0-9]+") String speciesName,
        Integer typeId,
        @Pattern(regexp = "[a-zA-Z0-9]+") String abilityName,
        Integer limit,
        Integer offset
) {
}
