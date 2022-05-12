package com.sda.restdemo.apiresponses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NearestCityResponse {

    @JsonProperty("data")
    private NearestCityData nearestCityData;

    @Data
    public static class NearestCityData {

        private String city;
        private String state;
        private String country;
        private LocationResponse location;

        @Data
        public static class LocationResponse {

            private List<Double> coordinates;
        }
    }
}
