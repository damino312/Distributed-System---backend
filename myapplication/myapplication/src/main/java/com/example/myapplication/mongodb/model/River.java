package com.example.myapplication.mongodb.model;

import com.example.myapplication.mysql.model.Country;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
public class River {
    @MongoId(FieldType.OBJECT_ID)
    private String id_river;
    private String name_river;
    private int length_river;
    private List<Country> countries_river;
    public River(){}


    public String getId_river() {
        return id_river;
    }

    public void setId_river(String id_river) {
        this.id_river = id_river;
    }

    public String getName_river() {
        return name_river;
    }

    public void setName_river(String name_river) {
        this.name_river = name_river;
    }

    public int getLength_river() {
        return length_river;
    }

    public void setLength_river(int length_river) {
        this.length_river = length_river;
    }

    public List<Country> getCountries_river() {
        return countries_river;
    }

    public void setCountries_river(List<Country> countries_river) {
        this.countries_river = countries_river;
    }

    @Override
    public String toString() {
        return "River{" +
                "id_river='" + id_river + '\'' +
                ", name_river='" + name_river + '\'' +
                ", length_river=" + length_river +
                ", countries_river=" + countries_river +
                '}';
    }
}
