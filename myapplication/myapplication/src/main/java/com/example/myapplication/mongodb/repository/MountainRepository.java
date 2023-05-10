package com.example.myapplication.mongodb.repository;

import com.example.myapplication.mongodb.model.Lake;
import com.example.myapplication.mongodb.model.Mountain;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MountainRepository extends MongoRepository<Mountain, String> {
    @Query("{ 'countries_mountain.name_country': ?0 }")
    List<Mountain> findByCountryName(String countryName);

    @Query("{ 'countries_mountain.id_country': ?0 }") // применяется для поиска и последующего удаления стран из mongodb, которые были удалены из mysql
    List<Mountain> findByCountryId(int countryId);
}

