package com.example.myapplication.mysql.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "country_nationality")
public class CountryNationality {

    @EmbeddedId
    CountryNationalityKey id;

    @ManyToOne
    @MapsId("idCountry")
    @JoinColumn(name = "id_country")
    Country country;

    @ManyToOne
    @MapsId("idNationality")
    @JoinColumn(name = "id_nationality")
    Nationality nationality;

    int population;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryNationality that = (CountryNationality) o;
        return population == that.population && id.equals(that.id) && country.equals(that.country) && nationality.equals(that.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, nationality, population);
    }

    public CountryNationalityKey getId() {
        return id;
    }

    public void setId(CountryNationalityKey id) {
        this.id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "CountryNationality{" +
                "id=" + id +
                ", country=" + country +
                ", nationality=" + nationality +
                ", population=" + population +
                '}';
    }
}
