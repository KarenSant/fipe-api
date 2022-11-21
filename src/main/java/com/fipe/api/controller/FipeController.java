package com.fipe.api.controller;

import com.fipe.api.model.entity.Brand;
import com.fipe.api.model.entity.Model;
import com.fipe.api.repository.jpa.BrandJPARepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/fipe")
public class FipeController {

    @Autowired
    BrandJPARepository brandJPARepository;

    @GetMapping("{marca}")
    public Set<Model> teste(@PathVariable String marca) {
        return brandJPARepository.findByName(marca)
                .map(Brand::getModels)
                .orElseThrow();
    }

    @GetMapping("flux/{marca}")
    public Flux<Model> brandModel(@PathVariable String marca) {
        return Flux.fromIterable(brandJPARepository.findByName(marca)
                .map(Brand::getModels)
                .orElseThrow()
        );
    }

}