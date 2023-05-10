package com.example.myapplication.mongodb.model;

import com.example.myapplication.mysql.model.Country;
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
public class Lake {
    @MongoId(FieldType.OBJECT_ID)
    private String id_lake;
    private String name_lake;
    private int area_lake;
    private List<Country> countries_lake;


}
