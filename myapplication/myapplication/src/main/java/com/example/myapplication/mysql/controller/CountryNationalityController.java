package com.example.myapplication.mysql.controller;


import com.example.myapplication.mysql.model.CountryNationality;

import com.example.myapplication.mysql.model.CountryNationalityKey;
import com.example.myapplication.mysql.repository.CountryNationalityRepository;
import com.example.myapplication.mysql.repository.CountryRepository;
import com.example.myapplication.mysql.repository.NationalityRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;

import java.util.List;


@RestController
@CrossOrigin("http://localhost:3000")
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
        System.out.println(countryNationality);
//        countryNationalityRepository.save(countryNationality);

    }

}
