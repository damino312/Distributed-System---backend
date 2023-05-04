package com.example.myapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CountryViewController {

    private CountryViewService countryViewService;
    @Autowired
    public CountryViewController(CountryViewService countryViewService) {
        this.countryViewService = countryViewService;
    }

    @GetMapping("/example")
    public List<String> getCountryRiversById() {
        return countryViewService.getCountryRiversById();
    }
}
