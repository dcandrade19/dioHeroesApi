package com.dca.heroesapi;

import java.util.List;

import com.dca.heroesapi.document.Hero;
import com.dca.heroesapi.service.HeroService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class Runner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(Runner.class);

    @Autowired
    private HeroService heroService;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Creating heroes");
        
        var heroes = List.of(new Hero("1", "Batman"),
        new Hero("2", "Miranha"),
        new Hero("3", "Superman"));

        Mono<Void> one = heroService.deleteAll();

        Flux<Hero> two = heroService.saveAll(heroes);

        Flux<Hero> three = heroService.findAll();

        three.subscribe(hero -> logger.info("{}", hero));

        Mono<Void> all = Mono.when(one, two, three);

        all.block();
    }

    
    
}
