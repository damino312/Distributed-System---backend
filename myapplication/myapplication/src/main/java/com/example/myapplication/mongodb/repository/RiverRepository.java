package com.example.myapplication.mongodb.repository;

import com.example.myapplication.mongodb.model.River;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiverRepository extends MongoRepository<River, String> {
}
