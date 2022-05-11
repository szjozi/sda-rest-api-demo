package com.sda.restdemo.providers;

import com.sda.restdemo.config.AppConfig;
import com.sda.restdemo.model.CountriesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AirVisualProvider {

    private final AppConfig appConfig;
    private final RestTemplate restTemplate;

    public CountriesResponse fetchCountriesList() {
        String url = String.format("%s/v2/countries?key=%s", appConfig.getApiBaseUrl(), appConfig.getApiKey());
        ResponseEntity<CountriesResponse> response = restTemplate.getForEntity(url, CountriesResponse.class);
        return response.getBody();
    }

}
