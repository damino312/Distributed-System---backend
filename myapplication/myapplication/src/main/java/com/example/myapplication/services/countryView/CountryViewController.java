package com.example.myapplication.services.countryView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class CountryViewController {

    @Autowired
    private CountryViewService countryViewService;


    @GetMapping("/getview/{id}")
    public CountryView getCountryRiversById(@PathVariable int id) {
        return countryViewService.getCountryRiversById(id);
    }
}
