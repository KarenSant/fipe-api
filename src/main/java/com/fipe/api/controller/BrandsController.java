package com.fipe.api.controller;

import com.fipe.api.client.FipeClient;
import com.fipe.api.model.entity.Brand;
import com.fipe.api.repository.BrandAsincRepository;
import com.fipe.api.repository.jpa.BrandJPARepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandsController {


    //private Brands marca;
    //private final WebClient client;
    //private List<Brands>  brands;
    @Autowired
    private BrandJPARepository brandJPARepository;

    @Autowired
    private BrandAsincRepository brandAsincRepository;

    @Autowired
    private FipeClient service;

    @PutMapping(path = "{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Brand> refreshByName(@PathVariable String name, @RequestBody Brand brand){
        brand.setName(name);
        return Mono.just(this.brandJPARepository
                .save(brand));
    }

    @PostMapping(path = "/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono <Brand> createBrands(@RequestBody Brand brand) {
        return Mono.just(brandJPARepository.save(brand));
    }
    @GetMapping("/{name}")
    //public ResponseEntity<List<Brands>>listByName(@RequestParam String name) {
    public Mono<Brand> findByName(@PathVariable String name){
        return Mono.justOrEmpty(brandJPARepository.findByName(name));
        //return new ResponseEntity<List<Brands>>(marcasRepository.searchByName(name), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public Mono<Brand> deleteBrands (@PathVariable Long id){
        try {
            this.brandAsincRepository
                    .delete(id);
        }catch (Exception e){
            throw new RuntimeException("Não foi possível deletar a marca");
        }

        return  Mono.empty();
    }


}

