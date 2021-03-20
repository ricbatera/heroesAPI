package com.digitalinovation.heroeapi;

import com.digitalinovation.heroeapi.repository.HeroesRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.digitalinovation.heroeapi.constants.HeroesConstant.HEROES_ENDPOINT_LOCAL;

@SpringBootTest
class HeroeapiApplicationTests {
	@Autowired
	WebTestClient webTestClient;

	@Autowired
	HeroesRepository heroesRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void getHeroByID(){
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), 1)
				.exchange()
				.expectStatus().isOk()
				.expectBody();
	}

	@Test
	public void getHeroByIDNotFound(){
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), 1)
				.exchange()
				.expectStatus().isNotFound();
	}

	@Test
	public void deletarHero(){
		webTestClient.get().uri(HEROES_ENDPOINT_LOCAL.concat("/{id}"), 1)
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNoContent()
				.expectBody(Void.class);
	}

}
