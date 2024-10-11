package com.desafiogg.api_utilizada_rick_and_morty_api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoDTO {
    private int count;
    private int pages;
    private String next;
    private String prev;
}