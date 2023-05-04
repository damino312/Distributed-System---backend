package com.example.myapplication.mongodb.controller;

import com.example.myapplication.mongodb.exception.RiverNotFoundException;
import com.example.myapplication.mongodb.model.Mountain;
import com.example.myapplication.mongodb.repository.MountainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class MountainController {
    @Autowired
    private MountainRepository mountainRepository;

    @PostMapping("/mountain")
    Mountain newMountain(@RequestBody Mountain newMountain) {
        return mountainRepository.save(newMountain);
    }

    @GetMapping("/mountains")
    List<Mountain> getAllMountains() {
        return mountainRepository.findAll();
    }

    @GetMapping("/mountain/{id}")
    Mountain getMountainId(@PathVariable String id) {
        return mountainRepository.findById(id)
                .orElseThrow(()-> new RiverNotFoundException(id)); // left it be, check when you have time
    }

    @PutMapping("/mountain/{id}")
    Mountain updateMountain(@RequestBody Mountain newMountain, @PathVariable String id) {
        return mountainRepository.findById(id)
                .map(Mountain -> {
                    Mountain.setName_mountain(newMountain.getName_mountain());
                    Mountain.setHeight_mountain(newMountain.getHeight_mountain());
                    Mountain.setCountries_mountain(newMountain.getCountries_mountain());
                    return mountainRepository.save(Mountain);
                }).orElseThrow(()->new RiverNotFoundException(id)); // left it be, check when you have time

    }
    @DeleteMapping("/mountain/{id}")
    String deleteMountain(@PathVariable String id) {
        if (!mountainRepository.existsById(id)){
            throw new RiverNotFoundException(id); // left it be, check when you have time
        }
        mountainRepository.deleteById(id);
        return "Mountain with id " +id+ " has been deleted";
    }
}
