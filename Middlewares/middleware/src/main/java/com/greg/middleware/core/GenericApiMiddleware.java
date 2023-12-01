package com.greg.middleware.core;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/*
* Classe genérica para a comunicação com o endpoint de uma api.
*
* @author Greg
* @verion 1.0
* @since 2023-11-29
* */
@Component
public class GenericApiMiddleware<T> implements ApiClient<T> {
    private final RestTemplate restTemplate;

    public GenericApiMiddleware(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    /*
    * Realiza a chamada com o filtro na url em chamada específica para a api diretamente.
    * Torna-se uma camada a mais para poder chamar em qualquer ApiClient criado
    * Pois ele usa o RestTemplate para realizar a chamada, sem precisar fazer tratamento específico.
    *
    * @param String url do endpoint
    * @return String resposta da requisição da api
    * */
    @Override
    public String fetchData(String url) {
        return restTemplate.getForObject(url, String.class);
    }

    /*
    * Realiza a chamada com o filtro e retorna um TIPO específico.
    *
    * @param url do endpoint.
    * @param responseType classe para conversão.
    * @return objeto representando a conversão.
    * */
    @Override
    public T fetchDataObj(String url, Class<T> responseType) {
        return restTemplate.getForObject(url, responseType);
    }


}
