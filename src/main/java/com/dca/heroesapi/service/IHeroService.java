package com.dca.heroesapi.service;

import java.util.List;

import com.dca.heroesapi.document.Hero;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IHeroService {
    Mono<Hero> insert(Hero hero);
    Flux<Hero> saveAll(List<Hero> heroes);
    Mono<Hero> findById(String id);
    Flux<Hero> findAll();
    Mono<Void> deleteAll();
}