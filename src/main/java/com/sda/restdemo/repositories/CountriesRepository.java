package com.sda.restdemo.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import com.sda.restdemo.model.Country;

@Repository
public interface CountriesRepository extends PagingAndSortingRepository<Country, String>{

}
