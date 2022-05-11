package com.sda.restdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CountriesResponse {

    @JsonProperty("data")
    private List<CountriesDTO> countriesDTOList;


    @Data
    public static class CountriesDTO {

        @JsonProperty("country")
        private String name;
    }
}
