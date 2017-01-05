package com.mxiaixy.mapper;

import com.mxiaixy.pojo.Employee;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 雇员代理模式接口
 * Created by Mxia on 2017/1/4.
 */
public interface EmployeeMapper {

    @Select("select * from t_employee")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "empname",property = "empname"),
            @Result(column = "deptid",property = "deptid"),
            @Result(column = "deptid",property = "dept" ,
            one=@One(select = "com.mxiaixy.mapper.DeptMapper.findByDeptid")
            )
    })
    List<Employee> findAlldemo();

    Employee findById(Integer id);
    List<Employee> findByDeptid(Integer id);
    List<Employee> findAll();


}
