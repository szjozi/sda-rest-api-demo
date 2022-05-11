package com.sda.restdemo.services;

import com.sda.restdemo.model.Country;
import com.sda.restdemo.model.PageDTO;
import com.sda.restdemo.repos.CountriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountriesService {

    private final CountriesRepository countriesRepository;

    public PageDTO<Country> fetchAllCountries(int pageNo, int size) {
        PageRequest pageRequest = PageRequest.of(pageNo, size);
        Page<Country> countriesPage = countriesRepository.findAll(pageRequest);

        PageDTO<Country> countryPageDTO = new PageDTO<>();
        countryPageDTO.map(countriesPage);
        return countryPageDTO;
    }

}
