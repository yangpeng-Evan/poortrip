package com.yp.service;

import com.github.pagehelper.PageInfo;
import com.yp.SpringTests;
import com.yp.entity.City;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class CityServiceTest extends SpringTests {

    @Autowired
    private CityService cityService;
    @Test
    public void findAllCityByPage() {
        PageInfo<City> allCityByPage = cityService.findAllCityByPage(1, 5);
        for (City city : allCityByPage.getList()) {
            System.out.println(city);
        }
    }

    @Test
    public void findAllCity() {
        List<City> list = cityService.findAllCity();
        System.out.println(list);
    }

    @Test
    public void findCityById(){
        City cityNameById = cityService.findCityNameById(3);
        System.out.println(cityNameById);
    }
}