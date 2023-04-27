package com.example.myapplication.controller;

import com.example.myapplication.model.Country;
import com.example.myapplication.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping("/country")
    Country newCountry(@RequestBody Country newCountry) {
        return countryRepository.save(newCountry);
    }

    @GetMapping("/counties")
    List<Country> getAllUsers() {
        return countryRepository.findAll();
    }

}
