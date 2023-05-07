package com.example.myapplication.mysql.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.io.Serializable;
import java.util.Objects;


@Getter
@Setter
@ToString
@Embeddable
public class CountryNationalityKey implements Serializable {

    @Column(name= "id_country")
    int idCountry;

    @Column(name="id_nationality")
    int idNationality;

    public CountryNationalityKey(){}

    public CountryNationalityKey(int idCountry, int idNationality) {
        this.idCountry = idCountry;
        this.idNationality = idNationality;
    }

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




}
