package com.yp.controller;

import com.github.pagehelper.PageInfo;
import com.yp.entity.City;
import com.yp.entity.User;
import com.yp.service.CityService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/city")
public class CityConroller {

    @Autowired
    private CityService cityService;
    @GetMapping("/list")
    public String findAllCityInfo(Model model,
                                  @RequestParam(defaultValue = "1") Integer page,
                                  @RequestParam(defaultValue = "5") Integer size){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        PageInfo<City> pageInfo = cityService.findAllCityByPage(page, size);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("name",user.getName());
        return "city-list";
    }
}
