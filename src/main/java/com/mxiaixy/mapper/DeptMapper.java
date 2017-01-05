package com.mxiaixy.mapper;

import com.mxiaixy.pojo.Dept;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.lang.annotation.Target;
import java.util.List;

/**
 * Created by Mxia on 2017/1/4.
 */
public interface DeptMapper {

    List<Dept> findById(Integer id);
    List<Dept> findAll();

    /**
     * 测试注解配置一对多
     */
    @Select("select * from t_dept")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column ="deptname",property = "deptname"),
            @Result(column = "id",property = "employeeList" ,
            many = @Many(select="com.mxiaixy.mapper.EmployeeMapper.findByDeptid")
            )

    })
    List<Dept> findAllDemo();
}
