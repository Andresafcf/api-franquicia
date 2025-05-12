package com.franquicia.api;

import com.franquicia.api.model.Franquicia;
import com.franquicia.api.repository.FranquiciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiApplication {

	@Autowired
	private FranquiciaRepository franquiciaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
	}
}
