package com.mxiaixy.mapper;

import com.mxiaixy.pojo.User;

import java.util.List;

/**
 * 代理模式
 * 使用接口来实现配置文件中的sql查询
 * Created by Mxia on 2017/1/4.
 */
public  interface UserMapper {
    User findById(Integer id);
    void save(User user);
    void update(User user);
    void delById(Integer id);
    List<User> findAll();
}
