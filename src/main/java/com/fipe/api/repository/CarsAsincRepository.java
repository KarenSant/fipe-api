package com.fipe.api.repository;

import com.fipe.api.model.entity.Car;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarsAsincRepository {

    Mono<Car> save(Car car);

    Mono<Car> findByNameContaining(String name);

    Flux<Car> findByCategory(String category);


    Mono<Car> delete(Long id);

    Flux<Car> findAll(Car car);

}
