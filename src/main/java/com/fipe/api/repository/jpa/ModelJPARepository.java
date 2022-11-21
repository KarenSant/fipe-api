package com.fipe.api.repository.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fipe.api.model.entity.Model;

@Repository
public interface ModelJPARepository extends JpaRepository<Model, Long> {
     boolean existsByCode(String code);
    //List<ModeloMapper> searchByName(String name);




}
