package com.greg.middleware.core;

/*
* Interface para os métodos específicos de requisições de API's, podendo ter novo
* método específico para cada nova API.
*
* @author Greg
* @version 1.0
* @since 2023-11-29
* */
public interface ApiClient {

    /*
    * Método que vem um endpoint para realizar uma chamada api e retornar uma resposta em String
    * @param String endpoint
    * @return String resposta da api
    * */
    String fetchData(String endpoint);
}
