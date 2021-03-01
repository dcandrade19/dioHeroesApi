package com.dca.heroesapi.service;

import java.util.List;

import com.dca.heroesapi.document.Hero;
import com.dca.heroesapi.repository.HeroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroService implements IHeroService {

    @Autowired
    private HeroRepository repository;

    @Override
    public Mono<Hero> insert(Hero hero) {
        return repository.insert(hero);
    }

    @Override
    public Flux<Hero> saveAll(List<Hero> heroes) {
        return repository.saveAll(heroes);
    }

    @Override
    public Mono<Hero> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Flux<Hero> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Void> deleteAll() {
        return repository.deleteAll();
    }


}
