package com.sda.restdemo.controllers;

import com.sda.restdemo.model.Country;
import com.sda.restdemo.dto.PageDTO;
import com.sda.restdemo.services.CountriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/countries")
public class CountriesController {

    private final CountriesService countriesService;

    @GetMapping
    public PageDTO<Country> getAllCountries(@RequestParam(required = false, defaultValue = "0") int page,
                                            @RequestParam(required = false, defaultValue = "10") int size) {
        return countriesService.fetchAllCountries(page, size);
    }
}
