package com.example.myapplication.mysql.controller;

import com.example.myapplication.mysql.exception.CountryNotFoundException;
import com.example.myapplication.mysql.model.Country;
import com.example.myapplication.mysql.repository.CountryRepository;
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
    List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @GetMapping("/country/{id}")
    Country getCountryId(@PathVariable int id) {
        return countryRepository.findById(id)
                .orElseThrow(()-> new CountryNotFoundException(id));
    }

    @PutMapping("/country/{id}")
    Country updateCountry(@RequestBody Country newCountry, @PathVariable int id) {
        return countryRepository.findById(id)
                .map(country -> {
                    country.setName_country(newCountry.getName_country());
                    country.setCapital_country(newCountry.getCapital_country());
                    country.setArea_country(newCountry.getArea_country());
                    country.setPopulation_country(newCountry.getPopulation_country());
                    return countryRepository.save(country);
                }).orElseThrow(()->new CountryNotFoundException(id));
    }
    @DeleteMapping("/country/{id}")
    String deleteCountry(@PathVariable int id) {
        if (!countryRepository.existsById(id)){
            throw new CountryNotFoundException(id);
        }
        countryRepository.deleteById(id);
        return "User with id " +id+ " has been deleted";
    }

}
