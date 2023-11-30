package com.greg.middleware.clients;

import com.greg.middleware.core.GenericApiMiddleware;
import org.springframework.stereotype.Component;

/*
* Camada para estabelecer uma comunicação com o endpoint para uma api específica.
*
* @author Greg
* @version 1.0
* @since 2023-11-29
* */
@Component
public class PokemonApiClient {

    private final GenericApiMiddleware apiMiddleware;
    private String url;

    public PokemonApiClient(GenericApiMiddleware apiMiddleware) {
        this.apiMiddleware = apiMiddleware;
        url = "https://pokeapi.co/api/v2/";;
    }

    /*
    * Método para enviar a requisição para a api e retornar uma String com a resposta.
    *
    * @param String endpoint para comunicação
    * @return String resposta da api
    * */
    public String fetchDataFromApi(String endpoint) {
        return apiMiddleware.fetchData(url + endpoint);
    }
}
