package com.sda.restdemo.repos;


import com.sda.restdemo.model.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountriesRepository extends PagingAndSortingRepository<Country, String> {

}
