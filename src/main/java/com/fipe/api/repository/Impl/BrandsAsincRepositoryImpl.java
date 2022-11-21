package com.fipe.api.repository.Impl;

import com.fipe.api.model.entity.Brand;
import com.fipe.api.repository.BrandAsincRepository;
import com.fipe.api.repository.jpa.BrandJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class BrandsAsincRepositoryImpl implements BrandAsincRepository {

    private BrandJPARepository brandJPARepository;


    @Override
    public Mono<Brand> createBrand(Brand brand) {

        return Mono.just(brandJPARepository.save(brand));
    }

    @Override
    public Mono<Brand> findById(Long id) {
        return Mono.justOrEmpty(brandJPARepository.findById(id));
    }

    @Override
    public Mono<Void> updateBrand(Brand brand) {
        brandJPARepository.save(brand);
        return Mono.empty();
    }

    @Override
    public Mono<Brand> save(Brand brand) {
        return Mono.just(brandJPARepository.save(brand));
    }

    @Override
    public Mono<Void> delete(Long id) {
        brandJPARepository.deleteById(id);
        return Mono.empty();
    }

    @Override
    public Flux<Brand> findAll() {
        return Flux.fromIterable(brandJPARepository.findAll());
    }


    public Mono<Boolean> notExistsByCode(String code) {
        return Mono.just(!brandJPARepository.existsByKey2(code));
        //return null;

    }

    public boolean notExistsByCode2(String code) {
        return !brandJPARepository.existsByKey2(code);
        //return null;

    }


}
