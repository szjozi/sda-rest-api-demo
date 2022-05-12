package com.sda.restdemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.sda.restdemo.model.NearestCity;

import java.util.List;

@Repository
public interface NearestCityRepository extends CrudRepository<NearestCity, Long> {

    @Override
    List<NearestCity> findAll();

}
