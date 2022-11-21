package com.fipe.api.repository;

import com.fipe.api.model.entity.Model;

import reactor.core.publisher.Mono;

public interface ModelAsincRepository {
    Mono<Model> save(Model model);

    Mono<Boolean> notExistsByCode(String code);

}
