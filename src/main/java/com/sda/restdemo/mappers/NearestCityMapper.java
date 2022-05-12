package com.sda.restdemo.mappers;

import com.sda.restdemo.apiresponses.NearestCityResponse;
import org.springframework.stereotype.Component;
import com.sda.restdemo.model.Location;
import com.sda.restdemo.model.NearestCity;

@Component
public class NearestCityMapper {

    public NearestCity map(NearestCityResponse nearestCityResponse) {
        NearestCityResponse.NearestCityData nearestCityData = nearestCityResponse.getNearestCityData();
        var locationResponse = nearestCityData.getLocation();

        Location location = Location.builder()
                .longitude(locationResponse.getCoordinates().get(0))
                .latitude(locationResponse.getCoordinates().get(1))
                .build();

        return NearestCity.builder()
                .city(nearestCityData.getCity())
                .state(nearestCityData.getState())
                .country(nearestCityData.getCountry())
                .location(location)
                .build();
    }
}
