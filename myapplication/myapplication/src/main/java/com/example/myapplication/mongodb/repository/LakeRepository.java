package com.example.myapplication.mongodb.repository;


import com.example.myapplication.mongodb.model.Lake;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface LakeRepository extends MongoRepository<Lake, String> {
    @Query("{ 'countries_lake.name_country': ?0 }")
    List<Lake> findByCountryName(String countryName);

    @Query("{ 'countries_lake.id_country': ?0 }") // применяется для поиска и последующего удаления стран из mongodb, которые были удалены из mysql
    List<Lake> findByCountryId(int countryId);
}

