package com.greg.middleware.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*
* Configuraçãos da API
*
* @author Greg
* @version 1.0
* @since 2023-11-29
* */
@Configuration
public class ApiConfig {

    /*
    * Irá reproduzir um Bean gerenciado pelo Spring.
    * Configura e fornece uma intância do RestTemplate.
    * @return Uma instância configurada pelo RestTemplate.
    * */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
