package com.example.myapplication.mysql.repository;


import com.example.myapplication.mysql.model.CountryNationality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryNationalityRepository extends JpaRepository<CountryNationality, Integer> {
}
