package com.fipe.api.repository.Impl;

import com.fipe.api.model.entity.Model;
import com.fipe.api.repository.ModelAsincRepository;
import com.fipe.api.repository.jpa.ModelJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Repository
public class ModelAsincRepositoryImpl implements ModelAsincRepository {


    private ModelJPARepository modelJPARepository;

    @Override
    public Mono<Model> save(Model modeloMapper) {

        return Mono.just(modelJPARepository.save(modeloMapper));

    }

    public Mono<Boolean> notExistsByCode(String code) {
        return Mono.just(!modelJPARepository.existsByCode(code));

    }


}
