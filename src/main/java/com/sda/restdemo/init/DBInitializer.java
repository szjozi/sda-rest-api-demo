package com.sda.restdemo.init;

import com.sda.restdemo.model.CountriesResponse;
import com.sda.restdemo.model.Country;
import com.sda.restdemo.providers.AirVisualProvider;
import com.sda.restdemo.repos.CountriesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class DBInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final AirVisualProvider airVisualProvider;
    private final CountriesRepository countriesRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Initializing DB");
        CountriesResponse countriesResponse = airVisualProvider.fetchCountriesList();
        List<CountriesResponse.CountriesDTO> list = countriesResponse.getCountriesDTOList();

        if (list.isEmpty()) {
            return;
        }

        Set<Country> countries = list.stream()
                .map(responseCountry -> new Country(responseCountry.getName()))
                .collect(Collectors.toSet());

        countriesRepository.saveAll(countries);
        log.info("Initializing DB finished successfully.");
    }

}
