package com.desafiogg.api_utilizada_rick_and_morty_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ApiUtilizadaRickAndMortyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiUtilizadaRickAndMortyApiApplication.class, args);
	}

}
