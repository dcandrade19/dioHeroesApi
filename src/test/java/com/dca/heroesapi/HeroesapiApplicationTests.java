package com.dca.heroesapi;

import com.dca.heroesapi.repository.HeroRepository;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
class HeroesapiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	WebTestClient webTestClient;

	@Autowired
	HeroRepository heroRepository;

	@Test
	public void getAllHeroes() {
		webTestClient.get().uri("http://localhost:8080/api/heroes").exchange().expectStatus().isOk().expectBody();
	}

	@Test
	public void getHeroById() {
		webTestClient.get().uri("http://localhost:8080/api/heroes/{id}", "2").accept(MediaType.APPLICATION_JSON)
				.exchange().expectStatus().isOk().expectBody();
	}

	@Test
	public void getOneHeroNotFound() {
		webTestClient.get().uri("http://localhost:8080/api/heroes/{id}", "999").exchange().expectStatus().isNotFound();
	}

}
