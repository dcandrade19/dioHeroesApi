package com.dca.heroesapi.repository;

import com.dca.heroesapi.document.Hero;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

@Configuration
public interface HeroRepository extends ReactiveMongoRepository<Hero, String>{
    
}
