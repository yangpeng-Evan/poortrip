package com.yp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yp.entity.City;
import com.yp.entity.TripInfo;
import com.yp.entity.User;
import com.yp.enums.PoorEnum;
import com.yp.exception.PoorException;
import com.yp.mapper.TripMapper;
import com.yp.service.TripService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yangpeng
 */
@Service
@Slf4j
public class TripServiceImpl implements TripService {

    @Resource
    private TripMapper tripMapper;
    @Override
    public PageInfo<TripInfo> findAllTripInfo(Integer page, Integer size) {
        //查询当前用户的旅行信息
        User user = (User) SecurityUtils.getSubject().getPrincipal();

        //开启分页
        PageHelper.startPage(page,size);
        List<TripInfo> list = tripMapper.findAllTripByUserId(user.getId());
        //封装查询到的数据
        PageInfo<TripInfo> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public TripInfo findTripById(Integer id) {
        TripInfo tripInfo = new TripInfo();
        tripInfo.setId(id);
        TripInfo trip = tripMapper.selectOne(tripInfo);
        return trip;
    }

    @Override
    public Integer deleteTripById(Integer id) {
        int i = tripMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public void add(TripInfo tripInfo) {
        int count = tripMapper.insertSelective(tripInfo);
        if (count != 1){
            log.error("【添加旅游信息】 添加旅游信息失败！！！tripInfo={}",tripInfo);
            throw new PoorException(PoorEnum.PARAM_ERROR);
        }
    }

}
