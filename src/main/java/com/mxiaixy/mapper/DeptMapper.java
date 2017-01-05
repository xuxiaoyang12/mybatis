package com.mxiaixy.mapper;

import com.mxiaixy.pojo.Dept;

import java.util.List;

/**
 * Created by Mxia on 2017/1/4.
 */
public interface DeptMapper {

    List<Dept> findById(Integer id);
    List<Dept> findAll();
}
