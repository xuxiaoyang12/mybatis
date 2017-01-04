package com.mxiaixy.test;

import com.mxiaixy.mapper.EmployeeMapper;
import com.mxiaixy.pojo.Employee;
import com.mxiaixy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * Created by Mxia on 2017/1/4.
 */
public class EmployeeTestCase {
    @Test
    public void  findById(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();

        //获取实现类
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        Employee employee = employeeMapper .findById(1);
        System.out.println(employee);

        sqlSession.close();


    }
}
