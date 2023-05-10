package com.example.myapplication.mongodb.model;

import com.example.myapplication.mysql.model.Country;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Getter
@Setter
@ToString
@Document
public class River {
    @MongoId(FieldType.OBJECT_ID)
    private String id_river;
    private String name_river;
    private int length_river;
    private List<Country> countries_river;

}
