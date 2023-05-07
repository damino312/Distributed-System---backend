package com.example.myapplication.mysql.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;
@Getter
@Setter
@ToString
@Entity
@Table(name = "country_nationality")
public class CountryNationality {

    @EmbeddedId
    CountryNationalityKey id;

    @ManyToOne
    @MapsId("idCountry")
    @JoinColumn(name = "id_country")
    @JsonBackReference(value="countryRef")
    Country country_link;

    @ManyToOne
    @MapsId("idNationality")
    @JoinColumn(name = "id_nationality")
    @JsonBackReference(value="nationalityRef")
    Nationality nationality_link;

    int population;

    public CountryNationality() {
    }

    public CountryNationality(CountryNationalityKey id, Country country_link, Nationality nationality_link, int population) {
        this.id =  new CountryNationalityKey(country_link.getId_country(), nationality_link.getId_nationality());
        this.country_link = country_link;
        this.nationality_link = nationality_link;
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryNationality that = (CountryNationality) o;
        return population == that.population && Objects.equals(id, that.id) && Objects.equals(country_link, that.country_link) && Objects.equals(nationality_link, that.nationality_link);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country_link, nationality_link, population);
    }




}
