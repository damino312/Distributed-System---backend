package com.example.myapplication.mysql.controller;


import com.example.myapplication.mysql.exception.CountryNotFoundException;
import com.example.myapplication.mysql.model.CountryNationality;

import com.example.myapplication.mysql.model.CountryNationalityKey;
import com.example.myapplication.mysql.repository.CountryNationalityRepository;
import com.example.myapplication.mysql.repository.CountryRepository;
import com.example.myapplication.mysql.repository.NationalityRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CountryNationalityController {
    @Autowired
    private CountryNationalityRepository countryNationalityRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private NationalityRepository nationalityRepository;
    // Get all country-nationality relationships
    @GetMapping("/country-nationalities")
    List<CountryNationality> getAllCountryNationalities() {
        return countryNationalityRepository.findAll();
    }
    // Create a new country-nationality relationship

    @PostMapping("/country-nationality")
    public void createCountryNationality1(@RequestBody CountryNationality countryNationality)  {
        CountryNationalityKey countryNationalityKey = new CountryNationalityKey(countryNationality.getCountry_link().getId_country(), countryNationality.getNationality_link().getId_nationality() );
        countryNationality.setId(countryNationalityKey);
        System.out.println(countryNationality);
        countryNationalityRepository.save(countryNationality);
    }

    @DeleteMapping("/country-nationality/{countryId}/{nationalityId}")
    public String deleteCountry(@PathVariable int countryId, @PathVariable int nationalityId  ) {
        CountryNationalityKey countryNationalityKey = new CountryNationalityKey(countryId, nationalityId);

        CountryNationality existingCountryNationality = countryNationalityRepository.findById(countryNationalityKey)
                .orElseThrow(() -> new CountryNotFoundException(1234)); // change when you have time
        countryNationalityRepository.delete(existingCountryNationality);
        return "CountryNationality with id " +countryNationalityKey+ " has been deleted";
    }

    @PutMapping("/country-nationality/{countryId}/{nationalityId}")
    public void updateCountryNationality(@RequestBody CountryNationality newCountryNationality,@PathVariable int countryId, @PathVariable int nationalityId ) {
        CountryNationalityKey countryNationalityKey = new CountryNationalityKey(countryId, nationalityId);
        newCountryNationality.setId(countryNationalityKey);
        CountryNationality existingCountryNationality = countryNationalityRepository.findById(countryNationalityKey)
                .orElseThrow(() -> new CountryNotFoundException(0));
        existingCountryNationality.setPopulation(newCountryNationality.getPopulation());
        // Update other properties as needed
        countryNationalityRepository.save(existingCountryNationality);
    }

}
