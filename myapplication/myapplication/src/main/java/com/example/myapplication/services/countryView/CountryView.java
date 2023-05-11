package com.example.myapplication.services.countryView;

import com.example.myapplication.mongodb.model.Lake;
import com.example.myapplication.mongodb.model.Mountain;
import com.example.myapplication.mongodb.model.River;
import com.example.myapplication.mysql.model.Country;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@Getter
@Setter
@ToString
@CrossOrigin("http://localhost:3000")
public class CountryView {
    private Country country;
    private List<River> rivers;
    private List<Mountain> mountains;
    private List<Lake> lakes;
    private int highestMountain;
    private int riversLength;
    private int lakesArea;
    public CountryView() {}

    public CountryView(Country country, List<River> rivers, List<Mountain> mountains, List<Lake> lakes, int highestMountain, int riversLength, int lakesArea) {
        this.country = country;
        this.rivers = rivers;
        this.mountains = mountains;
        this.lakes = lakes;
        this.highestMountain = highestMountain;
        this.riversLength = riversLength;
        this.lakesArea = lakesArea;
    }
}
