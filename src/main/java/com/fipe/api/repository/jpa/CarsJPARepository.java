package com.fipe.api.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fipe.api.model.entity.Car;

@Repository
public interface CarsJPARepository extends JpaRepository<Car, Long> {

//    List<Cars> findByNameContaining(String name);

//    List<Cars> findByCategoryContaining(String category);

//    List<Cars> findByKey2Containing(String key2);

}
