package com.mxiaixy.mapper;

import com.mxiaixy.pojo.Employee;

import java.util.List;

/**
 * 雇员代理模式接口
 * Created by Mxia on 2017/1/4.
 */
public interface EmployeeMapper {

    Employee findById(Integer id);
    List<Employee> findByDeptid(Integer id);


}
