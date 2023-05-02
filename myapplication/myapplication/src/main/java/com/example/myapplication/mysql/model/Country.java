package com.example.myapplication.mysql.model;

import jakarta.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_country;

    private String name_country;

    private String capital_country;

    private int area_country;

    private int population_country;

    public Integer getId_country() {
        return id_country;
    }

    public void setId_country(Integer id_country) {
        this.id_country = id_country;
    }

    public String getName_country() {
        return name_country;
    }

    public void setName_country(String name_country) {
        this.name_country = name_country;
    }

    public String getCapital_country() {
        return capital_country;
    }

    public void setCapital_country(String capital_country) {
        this.capital_country = capital_country;
    }

    public int getArea_country() {
        return area_country;
    }

    public void setArea_country(int area_country) {
        this.area_country = area_country;
    }

    public int getPopulation_country() {
        return population_country;
    }

    public void setPopulation_country(int population_country) {
        this.population_country = population_country;
    }
}




