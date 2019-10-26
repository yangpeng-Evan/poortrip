package com.yp.service;

import com.github.pagehelper.PageInfo;
import com.yp.entity.City;

import java.util.List;

/**
 * @author yangpeng
 */
public interface CityService {
    //分页查询城市信息
    PageInfo<City> findAllCityByPage(Integer page,Integer size);

    //查询全部城市接口
    List<City> findAllCity();

    //根据id查询城市名称
    City findCityNameById(Integer id);
}
