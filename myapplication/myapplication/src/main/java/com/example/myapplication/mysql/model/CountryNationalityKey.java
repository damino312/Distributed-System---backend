package com.example.myapplication.mysql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CountryNationalityKey implements Serializable {

    @Column(name= "id_country")
    int idCountry;

    @Column(name="id_nationality")
    int idNationality;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryNationalityKey that = (CountryNationalityKey) o;
        return idCountry == that.idCountry && idNationality == that.idNationality;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCountry, idNationality);
    }

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public int getIdNationality() {
        return idNationality;
    }

    public void setIdNationality(int idNationality) {
        this.idNationality = idNationality;
    }
}
