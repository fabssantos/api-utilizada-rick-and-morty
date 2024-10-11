package com.desafiogg.api_utilizada_rick_and_morty_api.controller;
import com.desafiogg.api_utilizada_rick_and_morty_api.dto.PersonagemDTO;
import com.desafiogg.api_utilizada_rick_and_morty_api.dto.PersonagensResponseDTO;
import com.desafiogg.api_utilizada_rick_and_morty_api.service.PersonagemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class PersonagemController {

    private final PersonagemService service;

    public PersonagemController(PersonagemService service) {
        this.service = service;
    }

    @Operation(description = "Consulta todos os personagens e retorna apensas ID e NOME de cada personagem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o ID e NOME dos personagens"),
            @ApiResponse(responseCode = "400", description = "Personagem não encontrado")
    })
    @GetMapping("/personagens")
    public Mono<PersonagensResponseDTO> getAllCharacters(@RequestParam(defaultValue = "2") int page) {
        return service.getAllCharacters(page);
    }

    @Operation(description = "Consulta personagem por nome")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna ID, NOME e SPECIES do personagem"),
            @ApiResponse(responseCode = "400", description = "Personagem Não encontrado")
    })
    @GetMapping("/personagem/{name}")
    public Mono<PersonagemDTO> getCharacterByName(@PathVariable String name) {
        return service.getCharacterByName(name);
    }
}