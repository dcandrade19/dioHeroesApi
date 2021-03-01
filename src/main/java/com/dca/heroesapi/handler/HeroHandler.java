package com.dca.heroesapi.handler;

import com.dca.heroesapi.document.Hero;
import com.dca.heroesapi.service.HeroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import reactor.core.publisher.Mono;

@Component
public class HeroHandler {

    @Autowired
    HeroService heroService;

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok().contentType(MediaType.APPLICATION_JSON).body(heroService.findAll(), Hero.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        var id = request.pathVariable("id");
        return ok().contentType(MediaType.APPLICATION_JSON).body(heroService.findById(id), Hero.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Hero> hero = request.bodyToMono(Hero.class);
        return ok().contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(hero.flatMap(heroService::insert), Hero.class));
    }
}