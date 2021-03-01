package com.dca.heroesapi.routes;

import com.dca.heroesapi.handler.HeroHandler;
import com.dca.heroesapi.repository.HeroRepository;
import com.dca.heroesapi.service.HeroService;

import org.springdoc.core.fn.builders.operation.Builder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springdoc.webflux.core.fn.SpringdocRouteBuilder.route;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

import java.util.function.Consumer;

@Configuration
public class HeroRouter {

    @Bean
    public RouterFunction<ServerResponse> heroRoute(HeroHandler heroHandler) {
        return route()
                .GET("/api/heroes", accept(APPLICATION_JSON), heroHandler::findAll,
                        ops -> ops.beanClass(HeroRepository.class).beanMethod("findAll"))
                .build()
                .and(route()
                        .GET("/api/heroes/{id}", accept(APPLICATION_JSON), heroHandler::findById,
                                ops -> ops.beanClass(HeroRepository.class).beanMethod("findById"))
                        .build().and(route().POST("/api/heroes/post", accept(APPLICATION_JSON), heroHandler::save,
                                ops -> ops.beanClass(HeroRepository.class).beanMethod("save")).build()));
    }

}
