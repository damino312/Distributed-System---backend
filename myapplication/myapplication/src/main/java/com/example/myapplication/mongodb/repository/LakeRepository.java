package com.example.myapplication.mongodb.repository;


import com.example.myapplication.mongodb.model.Lake;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LakeRepository extends MongoRepository<Lake, String> {
    @Query("{ 'countries_river.name_country': ?0 }")
    List<Lake> findByCountryName(String countryName); }

