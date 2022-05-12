package com.sda.restdemo.services;

import com.sda.restdemo.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.sda.restdemo.model.NearestCity;
import com.sda.restdemo.repositories.NearestCityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NearestCityService {

    private final NearestCityRepository nearestCityRepository;

    public List<NearestCity> fetchAll() {
        return nearestCityRepository.findAll();
    }

    public NearestCity getById(Long id) {
        return nearestCityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nearest City by ID " + id + " not found"));
    }


}
