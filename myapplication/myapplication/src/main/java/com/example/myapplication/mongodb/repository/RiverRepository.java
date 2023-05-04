package com.example.myapplication.mongodb.repository;

import com.example.myapplication.mongodb.model.River;
import com.example.myapplication.mysql.model.Country;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RiverRepository extends MongoRepository<River, String> {
    @Query("{ 'countries_river.name_country': ?0 }")
    List<River> findByCountryName(String countryName);





}
