package com.yp.controller;

import com.yp.enums.PoorEnum;
import com.yp.exception.PoorException;
import com.yp.exception.PoorExceptionHandler;
import com.yp.service.UserService;
import com.yp.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login-ui")
    public String loginUI(){
        return "login";
    }

    @PostMapping("/login")
    @ResponseBody
    public ResultVO login(String username,String password){
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            log.info("【登录功能】用户民或密码为空！！！username={},password={}",username,password);
            throw new PoorException(PoorEnum.PARAM_ERROR);
        }
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username,password));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            throw new PoorException(PoorEnum.USERNAMEORPASSWORD_ERROR);
        }
        return new ResultVO(0,"OK",null);
    }

    @GetMapping("/401")
    public String error(){
        return "401";
    }

}
