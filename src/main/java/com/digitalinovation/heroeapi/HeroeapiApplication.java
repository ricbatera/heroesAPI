package com.digitalinovation.heroeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HeroeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroeapiApplication.class, args);
		System.out.println("super poderes com webflux!");
	}

}
