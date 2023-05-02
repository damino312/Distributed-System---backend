package com.example.myapplication.mongodb.model;

import com.example.myapplication.mysql.model.Country;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document
@Table(name = "river")
public class River {
    @Id
    private String id_river;
    private String name_river;
    private int length_river;

    private List<Country> countries;
    public River(){}

    public River(String name_river, int length_river, List<Country> countries) {
        this.name_river = name_river;
        this.length_river = length_river;
        this.countries = countries;
    }

    public River(String id_river, String name_river, int length_river, List<Country> countries) {
        this.id_river = id_river;
        this.name_river = name_river;
        this.length_river = length_river;
        this.countries = countries;
    }

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

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
