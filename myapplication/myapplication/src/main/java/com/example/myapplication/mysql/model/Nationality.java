package com.example.myapplication.mysql.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "nationality")
public class Nationality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_nationality;
    private String name_nationality;

//    @OneToMany(mappedBy = "country")
//    Set<CountryNationality> populations;
//
//    public Set<CountryNationality> getPopulations() {
//        return populations;
//    }
//
//    public void setPopulations(Set<CountryNationality> populations) {
//        this.populations = populations;
//    }

    public int getId_nationality() {
        return id_nationality;
    }

    public void setId_nationality(int id_nationality) {
        this.id_nationality = id_nationality;
    }

    public String getName_nationality() {
        return name_nationality;
    }

    public void setName_nationality(String name_nationality) {
        this.name_nationality = name_nationality;
    }

    @Override
    public String toString() {
        return "Nationality{" +
                "id_nationality=" + id_nationality +
                ", name_nationality='" + name_nationality + '\'' +
                '}';
    }
}
