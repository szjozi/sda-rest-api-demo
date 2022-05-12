package com.sda.restdemo.init;

import com.sda.restdemo.apiresponses.CountriesResponse;
import com.sda.restdemo.apiresponses.NearestCityResponse;
import com.sda.restdemo.enums.Role;
import com.sda.restdemo.exceptions.ResourceNotFoundException;
import com.sda.restdemo.mappers.NearestCityMapper;
import com.sda.restdemo.model.NearestCity;
import com.sda.restdemo.providers.AirVisualProvider;
import com.sda.restdemo.repositories.CountriesRepository;
import com.sda.restdemo.repositories.LocationRepository;
import com.sda.restdemo.repositories.NearestCityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import com.sda.restdemo.dto.UserDTO;
import com.sda.restdemo.model.Country;
import com.sda.restdemo.services.UsersDetailsServiceImpl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class DBInitializer implements ApplicationListener<ContextRefreshedEvent> {

    private final AirVisualProvider airVisualProvider;
    private final NearestCityMapper nearestCityMapper;
    private final LocationRepository locationRepository;
    private final CountriesRepository countriesRepository;
    private final NearestCityRepository nearestCityRepository;
    private final UsersDetailsServiceImpl usersDetailsService;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("Initializing DB");

        initUsers();
        initCountries();
        initNearestCityData();

        log.info("Initializing DB finished successfully.");
    }

    private void initUsers() {

        UserDTO user = new UserDTO();
        user.setPassword("pass");
        user.setUsername("user");
        user.setRole(Role.USER);

        UserDTO admin = new UserDTO();
        admin.setPassword("pass");
        admin.setUsername("admin");
        admin.setRole(Role.ADMIN);

        usersDetailsService.addUser(user);
        usersDetailsService.addUser(admin);
    }

    private void initCountries() {
        CountriesResponse countriesResponse = airVisualProvider.fetchCountriesList();
        List<CountriesResponse.CountryNameResponse> list = countriesResponse.getCountryNameResponseList();

        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Api response empty");
        }

        Set<Country> countries = list.stream()
                .map(responseCountry -> new Country(responseCountry.getName()))
                .collect(Collectors.toSet());

        countriesRepository.saveAll(countries);
    }

    private void initNearestCityData() {
        NearestCityResponse nearestCityResponse = airVisualProvider.getNearestCity();
        NearestCity nearestCity = nearestCityMapper.map(nearestCityResponse);

        locationRepository.save(nearestCity.getLocation());
        nearestCityRepository.save(nearestCity);
    }
}
