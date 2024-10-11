package com.desafiogg.api_utilizada_rick_and_morty_api.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class PersonagemWebClient {

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                .baseUrl("https://rickandmortyapi.com/api")
                .build();
    }
}
