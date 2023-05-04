package com.example.myapplication.services;

import com.example.myapplication.mongodb.model.River;
import com.example.myapplication.mongodb.repository.RiverRepository;
import com.example.myapplication.mysql.model.Country;
import com.example.myapplication.mysql.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CountryViewService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RiverRepository riverRepository;

    public List<String> getCountryRiversById() {
        Optional<Country> optionalCountry = countryRepository.findById(1);
        Country country = optionalCountry.orElse(null);

        List<River> river = riverRepository.findByCountryName(country.getName_country());
        List<String> output = new ArrayList<>();
        for (River elem: river) {
            output.add(elem.getName_river());
        }
        return output;
    }
}
