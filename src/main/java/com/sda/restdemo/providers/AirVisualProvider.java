package com.sda.restdemo.providers;

import com.sda.restdemo.apiresponses.CountriesResponse;
import com.sda.restdemo.apiresponses.NearestCityResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.sda.restdemo.config.AppConfig;

@Service
@RequiredArgsConstructor
public class AirVisualProvider {

    private final AppConfig appConfig;
    private final RestTemplate restTemplate;

    public CountriesResponse fetchCountriesList(){
        String url = String.format("%s/countries?key=%s", appConfig.getApiBaseUrl(), appConfig.getApiKey());
        ResponseEntity<CountriesResponse> response = restTemplate.getForEntity(url, CountriesResponse.class);
        return response.getBody();
    }

    public NearestCityResponse getNearestCity(){
        String url = String.format("%s/nearest_city?key=%s", appConfig.getApiBaseUrl(), appConfig.getApiKey());
        ResponseEntity<NearestCityResponse> response = restTemplate.getForEntity(url, NearestCityResponse.class);
        return response.getBody();
    }

}
