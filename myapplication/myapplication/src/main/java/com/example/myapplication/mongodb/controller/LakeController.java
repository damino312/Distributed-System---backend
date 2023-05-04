package com.example.myapplication.mongodb.controller;

import com.example.myapplication.mongodb.exception.RiverNotFoundException;

import com.example.myapplication.mongodb.model.Lake;
import com.example.myapplication.mongodb.repository.LakeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class LakeController {
    @Autowired
    private LakeRepository lakeRepository;

    @PostMapping("/lake")
    Lake newLake(@RequestBody Lake newLake) {
        return lakeRepository.save(newLake);
    }

    @GetMapping("/lakes")
    List<Lake> getAllLakes() {
        return lakeRepository.findAll();
    }

    @GetMapping("/lake/{id}")
    Lake getLakeId(@PathVariable String id) {
        return lakeRepository.findById(id)
                .orElseThrow(()-> new RiverNotFoundException(id)); // left it be, check when you have time
    }

    @PutMapping("/lake/{id}")
    Lake updateLake(@RequestBody Lake newLake, @PathVariable String id) {
        return lakeRepository.findById(id)
                .map(Lake -> {
                    Lake.setName_lake(newLake.getName_lake());
                    Lake.setArea_lake(newLake.getArea_lake());
                    Lake.setCountries_lake(newLake.getCountries_lake());
                    return lakeRepository.save(Lake);
                }).orElseThrow(()->new RiverNotFoundException(id)); // left it be, check when you have time

    }
    @DeleteMapping("/lake/{id}")
    String deleteLake(@PathVariable String id) {
        if (!lakeRepository.existsById(id)){
            throw new RiverNotFoundException(id); // left it be, check when you have time
        }
        lakeRepository.deleteById(id);
        return "Lake with id " +id+ " has been deleted";
    }
}
