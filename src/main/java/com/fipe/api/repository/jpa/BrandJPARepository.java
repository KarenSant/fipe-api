package com.fipe.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fipe.api.model.entity.Brand;

import java.util.Optional;

@Repository
public interface BrandJPARepository extends JpaRepository<Brand, Long> {

    Optional<Brand> findByName(String name);

    boolean existsByKey2(String code);


}
