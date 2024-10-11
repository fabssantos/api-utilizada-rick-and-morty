package com.desafiogg.api_utilizada_rick_and_morty_api.service;

import com.desafiogg.api_utilizada_rick_and_morty_api.dto.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class PersonagemService {

    private final WebClient webClient;

    public PersonagemService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Cacheable("personagens")
    public Mono<PersonagensResponseDTO> getAllCharacters(int page) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/character")
                        .queryParam("page", page)
                        .build())
                .retrieve()
                .bodyToMono(PersonagensResponseDTO.class);
    }

    @Cacheable("personagem")
    public Mono<PersonagemDTO> getCharacterByName(String name) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder.path("/character")
                        .queryParam("name", name)
                        .build())
                .retrieve()
                .bodyToMono(PersonagemResponseDTO.class)
                .map(response -> {
                    if (response.getResults().isEmpty()) {
                        return null;
                    }
                    PersonagemDTO character = response.getResults().get(0);
                    return new PersonagemDTO(character.getId(), character.getName(), character.getSpecies());
                });
    }
}