package com.desafiogg.api_utilizada_rick_and_morty_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonagemResponseDTO {
    private List<PersonagemDTO> results;
    private InfoDTO info;
}