package com.digitalinovation.heroeapi;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDynamoDBRepositories
public class HeroeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroeapiApplication.class, args);
		System.out.println("super poderes com webflux!");
	}

}
