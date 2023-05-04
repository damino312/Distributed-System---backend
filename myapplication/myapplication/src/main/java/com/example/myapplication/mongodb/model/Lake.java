package com.example.myapplication.mongodb.model;

import com.example.myapplication.mysql.model.Country;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document
public class Lake {
    @MongoId(FieldType.OBJECT_ID)
    private String id_lake;
    private String name_lake;
    private int area_lake;
    private List<Country> countries_lake;

    public String getId_lake() {
        return id_lake;
    }

    public void setId_lake(String id_lake) {
        this.id_lake = id_lake;
    }

    public String getName_lake() {
        return name_lake;
    }

    public void setName_lake(String name_lake) {
        this.name_lake = name_lake;
    }

    public int getArea_lake() {
        return area_lake;
    }

    public void setArea_lake(int area_lake) {
        this.area_lake = area_lake;
    }

    public List<Country> getCountries_lake() {
        return countries_lake;
    }

    public void setCountries_lake(List<Country> countries_lake) {
        this.countries_lake = countries_lake;
    }
}
