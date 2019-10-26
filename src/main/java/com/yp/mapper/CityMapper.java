package com.yp.mapper;

import com.yp.entity.City;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface CityMapper extends Mapper<City> {

    //查询全部的城市信息
    List<City> findAllCity();
}
