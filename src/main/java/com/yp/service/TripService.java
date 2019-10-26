package com.yp.service;

import com.github.pagehelper.PageInfo;
import com.yp.entity.City;
import com.yp.entity.TripInfo;

import java.util.List;

/**
 * @author yangpeng
 */
public interface TripService {

    /**
     * 分页查询全部数据
     * @param page
     * @param size
     * @return
     */
    PageInfo<TripInfo> findAllTripInfo(Integer page,Integer size);


    /**
     * 根据id查询旅游信息接口
     * @param id
     * @return
     */
    TripInfo findTripById(Integer id);


    /**
     * 根据id删除旅游信息
     * @param id
     * @return
     */
    Integer deleteTripById(Integer id);


    /**
     * 添加旅游信息
     * @param tripInfo
     */
    void add(TripInfo tripInfo);
}
