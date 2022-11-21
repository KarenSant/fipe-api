package com.fipe.api.repository.Impl;

import com.fipe.api.model.entity.Car;
import com.fipe.api.repository.CarsAsincRepository;
import com.fipe.api.repository.jpa.CarsJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class CarsAsincRepositoryImpl implements CarsAsincRepository {


    private CarsJPARepository carsRepository;

    @Override
    public Mono<Car> save(Car car) {
        return Mono.just(carsRepository.save(car));
    }

    @Override
    public Mono<Car> findByNameContaining(String name) {
        //return Mono.just(carsRepository.findByNameContaining(name));
        return  null;
    }

    @Override
    public Flux<Car> findAll(Car car) {
        //return carsRepository.findAll(car);
        return  null;
    }

    @Override
    public Flux<Car> findByCategory(String category) {
        //return carsRepository.findByCategory(category);
        return  null;
    }

    @Override
    public Mono<Car> delete(Long id) {
        //return carsRepository.delete(id);
        return  null;
    }
}
