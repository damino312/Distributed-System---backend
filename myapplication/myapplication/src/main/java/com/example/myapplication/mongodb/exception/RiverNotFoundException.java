package com.example.myapplication.mongodb.exception;

public class RiverNotFoundException extends RuntimeException {
    public RiverNotFoundException(String id) {
        super("Could not find the country with id " + id);
    }
}


