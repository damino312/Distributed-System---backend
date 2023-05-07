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
@Table(name = "nationality")
public class Nationality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_nationality;
    private String name_nationality;
    @JsonManagedReference(value="nationalityRef")
    @OneToMany(mappedBy = "nationality_link")
    List<CountryNationality> populations;

    public Nationality(){}

    public Nationality(String name_nationality) {
        this.name_nationality = name_nationality;
    }

    public Nationality(int id_nationality, String name_nationality, List<CountryNationality> populations) {
        this.id_nationality = id_nationality;
        this.name_nationality = name_nationality;
        this.populations = populations;
    }


}
