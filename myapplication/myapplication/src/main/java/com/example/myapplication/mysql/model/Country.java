package com.example.myapplication.mysql.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Set;
@Getter
@Setter
@ToString
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
    @JsonManagedReference(value="countryRef")
    @OneToMany(mappedBy = "country_link")
    List<CountryNationality> populations;
    public Country(){}

    public Country(String name_country, String capital_country, int area_country, int population_country) {
        this.name_country = name_country;
        this.capital_country = capital_country;
        this.area_country = area_country;
        this.population_country = population_country;
    }

    public Country(Integer id_country, String name_country, String capital_country, int area_country, int population_country, List<CountryNationality> populations) {
        this.id_country = id_country;
        this.name_country = name_country;
        this.capital_country = capital_country;
        this.area_country = area_country;
        this.population_country = population_country;
        this.populations = populations;
    }

}




