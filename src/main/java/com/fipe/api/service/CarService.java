package com.fipe.api.service;

import com.fipe.api.model.entity.Car;
import com.fipe.api.repository.CarsAsincRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CarService {


    private CarsAsincRepository carsAsincRepository;

    public Mono<Car> create (Car car) {
        //System.out.println("SERVICE ID: "+id);
        return this.carsAsincRepository.save(car);

    }

    public Flux<Car> findAll (Car car){
        return this.carsAsincRepository.findAll(car);
    }


    public Mono<Car> findByName(String name){
        return this.carsAsincRepository.findByNameContaining(name);
    }

    public Mono<Car> update(Car car){
        return  this.carsAsincRepository.save(car);
    }

    public Mono<Car> delete(Long id){
        try {
            this.carsAsincRepository.delete(id);
        }catch (Exception e){
            throw new RuntimeException("Não foi possível deletar o carro");
        }
        return  Mono.empty();
    }



}
