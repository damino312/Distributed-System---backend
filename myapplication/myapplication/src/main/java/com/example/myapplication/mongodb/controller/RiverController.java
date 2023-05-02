package com.example.myapplication.mongodb.controller;

import com.example.myapplication.mongodb.model.River;
import com.example.myapplication.mongodb.repository.RiverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;

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
    List<River> getAllUsers() {
        return riverRepository.findAll();
    }

//    @GetMapping("/River/{id}")
//    River getRiverId(@PathVariable int id) {
//        return RiverRepository.findById(id)
//                .orElseThrow(()-> new RiverNotFoundException(id));
//    }

//    @PutMapping("/River/{id}")
//    River updateRiver(@RequestBody River newRiver, @PathVariable int id) {
//        return RiverRepository.findById(id)
//                .map(River -> {
//                    River.setName(newRiver.getName());
//                    River.setCapital(newRiver.getCapital());
//                    River.setArea(newRiver.getArea());
//                    River.setPopulation(newRiver.getPopulation());
//                    return RiverRepository.save(River);
//                }).orElseThrow(()->new RiverNotFoundException(id));
//    }
//    @DeleteMapping("/River/{id}")
//    String deleteRiver(@PathVariable int id) {
//        if (!RiverRepository.existsById(id)){
//            throw new RiverNotFoundException(id);
//        }
//        RiverRepository.deleteById(id);
//        return "User with id " +id+ " has been deleted";
//    }

}


