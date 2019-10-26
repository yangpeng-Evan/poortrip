package com.yp.service;

import com.github.pagehelper.PageInfo;
import com.yp.SpringTests;
import com.yp.entity.TripInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.Set;

import static org.junit.Assert.*;

public class TripServiceTest extends SpringTests {

    @Autowired
    private TripService tripService;
    @Autowired
    private UserService userService;
    @Test
    public void findAllTripInfo() {
        PageInfo<TripInfo> allTripInfo = tripService.findAllTripInfo(1, 5);
        for (TripInfo tripInfo : allTripInfo.getList()) {
            System.out.println(tripInfo);
        }

    }

    @Test
    public void findAllPermissions(){
        LinkedHashMap<String, String> filterChainDefinition = userService.findFilterChainDefinition();
        System.out.println(filterChainDefinition);
        Set<String> admin4 = userService.findRoleNamesByUsername("admin4");
        System.out.println(admin4);
        Set<String> permissionsByRoleNames = userService.findPermissionsByRoleNames(admin4);
        System.out.println(permissionsByRoleNames);
    }

    @Test
    public void findTripById(){
        TripInfo trip = tripService.findTripById(2);
        System.out.println(trip);
    }
}