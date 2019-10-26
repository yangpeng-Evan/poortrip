package com.yp.controller;

import com.github.pagehelper.PageInfo;
import com.yp.entity.City;
import com.yp.entity.TripInfo;
import com.yp.entity.User;
import com.yp.enums.PoorEnum;
import com.yp.exception.PoorException;
import com.yp.service.CityService;
import com.yp.service.TripService;
import com.yp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author yangpeng
 */
@Controller
@RequestMapping("/trip")
@Slf4j
public class TripController {

    @Autowired
    private TripService tripService;
    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public String findAllTripInfo(Model model,
                                    @RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "5") Integer size){
        PageInfo<TripInfo> tripInfo = tripService.findAllTripInfo(page, size);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("name",user.getName());
        model.addAttribute("tripInfo", tripInfo);
        return "trip-list";
    }

    @GetMapping("/update-ui")
    public String updateUI(Model model,
                           Integer id,
                           Integer startLand,
                           Integer targetLand){
        TripInfo trip = tripService.findTripById(id);
        List<City> cityList = cityService.findAllCity();
        City startLand1 = cityService.findCityNameById(startLand);
        City targetLand1 = cityService.findCityNameById(targetLand);
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("name",user.getName());
        model.addAttribute("trip",trip);
        model.addAttribute("startLand",startLand1);
        model.addAttribute("targetLand",targetLand1);
        model.addAttribute("cityList",cityList);
        return "trip-update";
    }

    @GetMapping("/delete")
    @ResponseBody
    public ResultVO deleteTrip(Integer id){
        Integer count = tripService.deleteTripById(id);
        if (count==0){
            log.info("【删除旅游信息】 删除旅游信息失败！ id不能为空！！id={}",id);
            throw new PoorException(PoorEnum.PARAM_ERROR);
        }
        return new ResultVO(0,"成功",null);
    }

    @GetMapping("/add-ui")
    public String addUI(Model model){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        model.addAttribute("name",user.getName());
        List<City> cityList = cityService.findAllCity();
        model.addAttribute("cityList",cityList);
        return "trip-add";
    }

    @PostMapping("/add")
    @ResponseBody
    public ResultVO addTrip(@Valid TripInfo tripInfo, BindingResult bindingResult){
//        1. 映射请求路径和请求方式.
//        2. 接收并校验参数.
        if (bindingResult.hasErrors()){
            String msg = bindingResult.getFieldError().getDefaultMessage();
            log.info("【添加旅游信息】 参数不正确！！！tripInfo={}",tripInfo);
            throw new PoorException(PoorEnum.PARAM_ERROR);
        }
//        3. 调用service保存数据.
        tripService.add(tripInfo);
//        4. 响应数据.
        return new ResultVO(0,"成功",null);
    }
}
