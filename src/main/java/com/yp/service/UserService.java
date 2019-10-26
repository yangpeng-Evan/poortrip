package com.yp.service;

import com.yp.entity.User;

import java.util.LinkedHashMap;
import java.util.Set;

public interface UserService {

    User findByUsername(String username);

    Set<String> findRoleNamesByUsername(String username);

    Set<String> findPermissionsByRoleNames(Set<String> roleNames);

    LinkedHashMap<String, String> findFilterChainDefinition();
}
