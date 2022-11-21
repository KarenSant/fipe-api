package com.fipe.api.repository;

import com.fipe.api.model.entity.Brand;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BrandAsincRepository {

    Mono<Brand> createBrand(Brand request);

    Mono<Void> updateBrand(Brand brand);

    Mono<Brand> save(Brand brand);

    Mono<Brand> findById(Long id);

    Mono<Void> delete(Long id);

    Flux<Brand> findAll();

    Mono<Boolean> notExistsByCode(String code);

    boolean notExistsByCode2(String code);

    //Publisher<Boolean> notExistsByCode(String code);
}
