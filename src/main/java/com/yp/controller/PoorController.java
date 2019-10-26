package com.yp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangpeng
 */
@Controller
@RequestMapping("/poor")
@Slf4j
public class PoorController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }

}
