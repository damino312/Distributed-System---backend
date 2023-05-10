package com.example.myapplication.mongodb.model;

import com.example.myapplication.mysql.model.Country;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
@Getter
@Setter
@ToString
@Document
public class Mountain {
    @MongoId(FieldType.OBJECT_ID)
    private String id_mountain;

    private String name_mountain;

    private int height_mountain;

    private List<Country> countries_mountain;


}
