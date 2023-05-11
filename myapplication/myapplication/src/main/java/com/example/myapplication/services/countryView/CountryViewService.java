package com.example.myapplication.services.countryView;

import com.example.myapplication.mongodb.model.Lake;
import com.example.myapplication.mongodb.model.Mountain;
import com.example.myapplication.mongodb.model.River;
import com.example.myapplication.mongodb.repository.LakeRepository;
import com.example.myapplication.mongodb.repository.MountainRepository;
import com.example.myapplication.mongodb.repository.RiverRepository;
import com.example.myapplication.mysql.exception.CountryNotFoundException;
import com.example.myapplication.mysql.model.Country;
import com.example.myapplication.mysql.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryViewService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private RiverRepository riverRepository;

    @Autowired
    private MountainRepository mountainRepository;

    @Autowired
    private LakeRepository lakeRepository;

    public CountryView getCountryRiversById(int id) {
        Country country = countryRepository.findById(id).orElseThrow(()-> new CountryNotFoundException(id));;

        List<River> rivers = riverRepository.findByCountryId(country.getId_country());
        List<Mountain> mountains = mountainRepository.findByCountryId(country.getId_country());
        List<Lake> lakes = lakeRepository.findByCountryId(country.getId_country());

        int highestMountain = getHighestMountain(mountains);
        int riversLength = getSumRivers(rivers);
        int lakesArea = getAreaLakes(lakes);


        return new CountryView(country, rivers, mountains, lakes, highestMountain, riversLength, lakesArea );
    }

    private int getSumRivers(List<River> rivers) {
        int sum = 0;
        for (River river: rivers) {
            sum += river.getLength_river();

        }
        return sum;
    }

    private int getAreaLakes(List<Lake> lakes) {
        int sum = 0;
        for (Lake lake: lakes) {
            sum += lake.getArea_lake();

        }
        return sum;
    }

    private int getHighestMountain(List<Mountain> mountains) {
        int highest=0;
        for (Mountain mountain: mountains) {
            if (mountain.getHeight_mountain() > highest) highest = mountain.getHeight_mountain();
        }
        return highest;
    }


}
