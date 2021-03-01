package com.dca.heroesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class HeroesapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HeroesapiApplication.class, args);
	}
}
