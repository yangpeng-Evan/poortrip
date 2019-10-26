package com.yp.service.impl;

import com.yp.entity.User;
import com.yp.mapper.UserMapper;
import com.yp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }

    @Override
    public Set<String> findRoleNamesByUsername(String username) {

        return userMapper.findRoleNamesByUsername(username);
    }

    @Override
    public Set<String> findPermissionsByRoleNames(Set<String> roleNames) {
        //1. 封装参数.
        Map<String,Object> map = new HashMap<>();
        map.put("set",roleNames);
        //2. 查询并返回
        return userMapper.findPermissionsByRoleNames(map);
    }

    @Override
    public LinkedHashMap<String, String> findFilterChainDefinition() {
        return userMapper.findFilterChainDefinition();
    }
}
