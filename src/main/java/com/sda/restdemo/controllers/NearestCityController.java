package com.sda.restdemo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sda.restdemo.model.NearestCity;
import com.sda.restdemo.services.NearestCityService;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
@RequiredArgsConstructor
public class NearestCityController {

    private final NearestCityService nearestCityService;

    @GetMapping
    public List<NearestCity> getAllCities(){
        return nearestCityService.fetchAll();
    }

    @GetMapping("/{id}")
    public NearestCity getCityById(@PathVariable Long id){
        return nearestCityService.getById(id);
    }

}
