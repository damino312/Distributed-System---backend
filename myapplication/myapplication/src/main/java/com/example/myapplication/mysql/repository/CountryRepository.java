package com.example.myapplication.mysql.repository;

import com.example.myapplication.mysql.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer> {

    @Query("SELECT c FROM Country c WHERE c.id_country = (SELECT MAX(id_country) FROM Country)")
    Country lastRecord();


}