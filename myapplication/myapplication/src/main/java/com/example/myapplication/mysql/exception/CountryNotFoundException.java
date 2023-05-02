package com.example.myapplication.mysql.exception;

public class CountryNotFoundException extends RuntimeException {
    public CountryNotFoundException(int id) {
        super("Could not find the country with id " + id);
    }
}
