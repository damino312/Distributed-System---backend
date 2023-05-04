package com.example.myapplication.mongodb.repository;

import com.example.myapplication.mongodb.model.Mountain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MountainRepository extends MongoRepository<Mountain, String> {
    @Query("{ 'countries_river.name_country': ?0 }")
    List<Mountain> findByCountryName(String countryName);
}

