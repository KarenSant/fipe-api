package com.fipe.api.controller;


import com.fipe.api.client.FipeClient;
import com.fipe.api.model.entity.Car;
import com.fipe.api.model.entity.Model;
import com.fipe.api.repository.jpa.CarsJPARepository;
import com.fipe.api.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarsJPARepository carsJPARepository;

    @Autowired
    private CarService service;


    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    //public Mono <ModeloMapper> findCarByName(@PathVariable String name){
    //public List <Model> findCarByName(@PathVariable String name){
    public Mono<Car> findCarByName(@PathVariable String name) {
        // service.searchCode(name).subscribe(x ->  x.getModels().forEach(z -> System.out.println(z.getName()+", "))); //System.out.println(x.getModels().get))
        return service.findByName(name);//.flatMapIterable(m -> m.getModels()).filter(m1 -> m1.getName().contains(name)).next();

    }

    @PostMapping("create")
    //public Mono<Cars> createCar(@PathVariable Long id){
    public Mono<Car> createCar(@RequestBody Car car) {

        System.out.println("CARS1: " + car.getId());
        return service.create(car);//createCars(cars);
    }

    @PutMapping("{id}")
    public Mono<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        car.setId(id);
        return service.update(car);
    }

    @DeleteMapping("{id}")
    public Mono<Car> deleteCar(@PathVariable Long id) {
        //cars.setId(id);
        return service.delete(id);
    }

    @GetMapping
    public Mono<Car> copyAPI(@PathVariable Car car) {
        this.carsJPARepository
                .save(car);
        return null;
    }

    @GetMapping("getAll")
    public Flux<Car> findAll(@RequestBody Car car) {
        return service.findAll(car);
    }




/*
    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Cars>list() {
        System.out.println(("aaaaaa list"));
        return carsRepository.findAll();
    }


    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Cars createCars(@Valid @RequestBody Cars createcar) {
        return carsRepository.save(createcar);
    }

    @PutMapping(path= "/refresh/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    Cars replaceCars(@RequestBody Cars newCars, @PathVariable Long id){
        return carsRepository.findById(id)
                .map( carro -> {
                    carro.setAmount(newCars.getAmount());
                    carro.setCategory(newCars.getCategory());
                    carro.setBrand_id(newCars.getBrand_id());
                    carro.setKey2(newCars.getKey2());
                    carro.setName(newCars.getName());
                    return carsRepository.save(carro);
                })
                .orElseGet(() -> {
                    newCars.setId(id);
                    return carsRepository.save(newCars);
                });
    }

    @DeleteMapping({"/{id}"})
    public void deleteById(@PathVariable("id") Long id){
            carsRepository.deleteById(id);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<Cars>>listByName(@PathVariable String name) {
        return new ResponseEntity<List<Cars>>(carsRepository.findByNameContaining(name), HttpStatus.OK);
    }

    @GetMapping("/cars/category/{category}")
    public ResponseEntity<List<Cars>> listByCategory(@PathVariable String category) {
       return  new  ResponseEntity<List<Cars>>(carsRepository.findByCategoryContaining(category), HttpStatus.OK);
    }
*/
}
