package com.example.myapplication.mongodb.controller;

import com.example.myapplication.mongodb.exception.RiverNotFoundException;
import com.example.myapplication.mongodb.model.Lake;
import com.example.myapplication.mongodb.repository.LakeRepository;
import com.example.myapplication.mysql.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class LakeController {
    @Autowired
    private LakeRepository lakeRepository;

    @PostMapping("/lake")
    Lake newLake(@RequestBody Lake newLake) {
        System.out.println(newLake);

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
                    System.out.println(Lake);
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


    public void deleteCountryFromLake(int id) {
        List<Lake> arrObj = lakeRepository.findByCountryId(id); // выбираает озера, где есть

        for (Lake obj : arrObj) { //перебирает каждый объект из массива, чтобы залезть массив countries_lake внутри него и удалить страну с заданным id
            Iterator<Country> iterator = obj.getCountries_lake().iterator();
            while (iterator.hasNext()) {
                Country country = iterator.next();
                if (country.getId_country().equals(id)) {
                    iterator.remove();
                }
            }
            lakeRepository.findById(obj.getId_lake()) // сразу постим измененные объекты
                    .map(Lake -> {
                        Lake.setCountries_lake(obj.getCountries_lake());
                        return lakeRepository.save(Lake);
                    });

        }

    }
}
