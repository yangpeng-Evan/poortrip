package com.yp.mapper;

import com.yp.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author yangpeng
 */
public interface UserMapper{

    //根据用户名查询用户信息
    @Select("select * from user where username = #{username}")
    User findByUsername(@Param("username") String username);

    //根据用户名查询角色信息
    @Select("select role_name from user_roles where username = #{username}")
    Set<String> findRoleNamesByUsername(@Param("username") String username);

    // 根据角色信息查询权限信息
    Set<String> findPermissionsByRoleNames(Map<String, Object> map);

    //查询过滤器链
    @Select("select * from filter_chain order by ordered asc")
    LinkedHashMap<String, String> findFilterChainDefinition();
}
