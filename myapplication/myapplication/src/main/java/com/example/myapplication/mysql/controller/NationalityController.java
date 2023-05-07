package com.example.myapplication.mysql.controller;

import com.example.myapplication.mysql.exception.CountryNotFoundException;

import com.example.myapplication.mysql.model.Nationality;
import com.example.myapplication.mysql.repository.CountryNationalityRepository;
import com.example.myapplication.mysql.repository.NationalityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class NationalityController {

    @Autowired
    private NationalityRepository nationalityRepository;

    @Autowired
    private CountryNationalityRepository countryNationalityRepository;

    @PostMapping("/nationality")
    Nationality newNationality(@RequestBody Nationality newNationality) {
        return nationalityRepository.save(newNationality);
    }

    @GetMapping("/nationalities")
    List<Nationality> getAllNationalities() {
        return nationalityRepository.findAll();
    }

    @GetMapping("/nationality/{id}")
    Nationality getNationalityId(@PathVariable int id) {
        return nationalityRepository.findById(id)
                .orElseThrow(()-> new CountryNotFoundException(id)); //let it be
    }

    @PutMapping("/nationality/{id}")
    Nationality updateNationality(@RequestBody Nationality newNationality, @PathVariable int id) {
        return nationalityRepository.findById(id)
                .map(nationality -> {
                    nationality.setName_nationality(newNationality.getName_nationality());
                    return nationalityRepository.save(nationality);
                }).orElseThrow(()->new CountryNotFoundException(id)); //let it be
    }
    @DeleteMapping("/nationality/{id}")
    String deleteNationality(@PathVariable int id) {
        if (!nationalityRepository.existsById(id)){
            throw new CountryNotFoundException(id);  //let it be
        }
        nationalityRepository.deleteById(id);
        return "Nationality with id " +id+ " has been deleted";
    }
}
