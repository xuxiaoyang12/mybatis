package com.mxiaixy.test;

import com.mxiaixy.mapper.EmployeeMapper;
import com.mxiaixy.pojo.Dept;
import com.mxiaixy.pojo.Employee;
import com.mxiaixy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Mxia on 2017/1/4.
 */
public class EmployeeTestCase {
    private SqlSession sqlSession;
    @Before
    public void setup(){
        //测试代码运行前执行
        sqlSession = SqlSessionFactoryUtils.getSqlSession();
    }
    @After
    public void  close(){
        //测试代码运行后执行
        sqlSession.close();
    }
    @Test
    public void  findById(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();

        //获取实现类
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

        //两边联查通过结果集映射到类employee中
        Employee employee = employeeMapper .findById(1);
        Dept dept =employee.getDept();
        //输出查询结果
        System.out.println(employee);

        //通过deptid查询 一个部门下有几个雇员
        List<Employee> employeeList = employeeMapper.findByDeptid(1);

        for(Employee employee1 : employeeList){
            employee1.setDept(dept);
            System.out.println(employee1);
        }

        sqlSession.close();


    }

    @Test
    public  void  findAll(){

        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);

       List<Employee> employeeList = employeeMapper.findAll();
       for(Employee employee:employeeList){
           System.out.println(employee);
       }
    }
}
