package com.example.myapplication.mongodb.model;

import com.example.myapplication.mysql.model.Country;
import jakarta.persistence.Table;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
@Document
public class Mountain {
    @MongoId(FieldType.OBJECT_ID)
    private String id_mountain;

    private String name_mountain;

    private int height_mountain;

    private List<Country> countries_mountain;

    public String getId_mountain() {
        return id_mountain;
    }

    public void setId_mountain(String id_mountain) {
        this.id_mountain = id_mountain;
    }

    public String getName_mountain() {
        return name_mountain;
    }

    public void setName_mountain(String name_mountain) {
        this.name_mountain = name_mountain;
    }

    public int getHeight_mountain() {
        return height_mountain;
    }

    public void setHeight_mountain(int height_mountain) {
        this.height_mountain = height_mountain;
    }

    public List<Country> getCountries_mountain() {
        return countries_mountain;
    }

    public void setCountries_mountain(List<Country> countries_mountain) {
        this.countries_mountain = countries_mountain;
    }
}
