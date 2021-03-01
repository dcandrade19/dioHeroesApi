package com.dca.heroesapi.controller;

import com.dca.heroesapi.document.Hero;
import com.dca.heroesapi.service.HeroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "api")
public class HeroController {

    @Autowired
    HeroService heroService;

    @GetMapping(value = "/heroes")
    public Flux<Hero> getHeroes() {
        return heroService.findAll();
    }

    @GetMapping(value = "/heroes/{id}")
    public Mono<ResponseEntity<Hero>> getHeroById(@PathVariable String id) {
        return heroService.findById(id).map((hero) -> new ResponseEntity<>(hero, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(value = "/heroes")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Hero> saveHero(@RequestBody Hero hero) {
        return heroService.insert(hero);
    }
}
