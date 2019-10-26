package com.yp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yp.entity.City;
import com.yp.mapper.CityMapper;
import com.yp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;
    @Override
    public PageInfo<City> findAllCityByPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<City> list = cityMapper.findAllCity();
        PageInfo<City> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public List<City> findAllCity() {
        List<City> cities = cityMapper.selectAll();
        return cities;
    }

    @Override
    public City findCityNameById(Integer id) {
        City city = new City();
        city.setId(id);
        City city1 = cityMapper.selectOne(city);
        return city1;
    }
}
