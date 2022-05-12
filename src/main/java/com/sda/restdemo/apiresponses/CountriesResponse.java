package com.sda.restdemo.apiresponses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CountriesResponse {
    @JsonProperty("data")
    List<CountryNameResponse> countryNameResponseList;


    @Data
    public static class CountryNameResponse {

        @JsonProperty("country")
        private String name;


    }
}
