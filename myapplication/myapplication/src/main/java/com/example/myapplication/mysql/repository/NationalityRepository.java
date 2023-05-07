package com.example.myapplication.mysql.repository;

import com.example.myapplication.mysql.model.Nationality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NationalityRepository extends JpaRepository<Nationality, Integer> {
}
