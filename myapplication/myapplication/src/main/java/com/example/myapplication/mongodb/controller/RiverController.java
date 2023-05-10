package com.example.myapplication.mongodb.controller;

import com.example.myapplication.mongodb.exception.RiverNotFoundException;
import com.example.myapplication.mongodb.model.River;
import com.example.myapplication.mongodb.repository.RiverRepository;
import com.example.myapplication.mysql.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class RiverController {
    @Autowired
    private RiverRepository riverRepository;

    @PostMapping("/river")
    River newRiver(@RequestBody River newRiver) {
        return riverRepository.save(newRiver);
    }

    @GetMapping("/rivers")
    List<River> getAllRivers() {
        return riverRepository.findAll();
    }

    @GetMapping("/river/{id}")
    River getRiverId(@PathVariable String id) {
        return riverRepository.findById(id)
                .orElseThrow(()-> new RiverNotFoundException(id));
    }

    @PutMapping("/river/{id}")
    River updateRiver(@RequestBody River newRiver, @PathVariable String id) {
        return riverRepository.findById(id)
                .map(River -> {
                    River.setName_river(newRiver.getName_river());
                    River.setLength_river(newRiver.getLength_river());
                    River.setCountries_river(newRiver.getCountries_river());
                    return riverRepository.save(River);
                }).orElseThrow(()->new RiverNotFoundException(id));

    }
    @DeleteMapping("/river/{id}")
    String deleteRiver(@PathVariable String id) {
        if (!riverRepository.existsById(id)){
            throw new RiverNotFoundException(id);
        }
        riverRepository.deleteById(id);
        return "User with id " +id+ " has been deleted";
    }

    public void deleteCountryFromRiver(int id) {
        List<River> arrObj = riverRepository.findByCountryId(id); // выбираает озера, где есть

        for (River obj : arrObj) { //перебирает каждый объект из массива, чтобы залезть массив countries_lake внутри него и удалить страну с заданным id
            Iterator<Country> iterator = obj.getCountries_river().iterator();
            while (iterator.hasNext()) {
                Country country = iterator.next();
                if (country.getId_country().equals(id)) {
                    iterator.remove();
                }
            }
            riverRepository.findById(obj.getId_river()) // сразу постим измененные объекты
                    .map(River -> {
                        River.setCountries_river(obj.getCountries_river());
                        return riverRepository.save(River);
                    });

        }

    }

}


