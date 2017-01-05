package com.mxiaixy.test;

import com.mxiaixy.mapper.DeptMapper;
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
public class DeptMapperTestCase {
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
    public void findById(){
        //获取数据查询对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //获取此=接口的实现类
        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
//        //查询
        List<Dept> deptList =  deptMapper.findById(1);
        for(Dept dept:deptList){
            System.out.println(dept);
        }

    }
    @Test
    public void  findAll(){

        DeptMapper deptMapper = sqlSession.getMapper(DeptMapper.class);
        List<Dept> deptList = deptMapper.findAll();
        for(Dept dept:deptList){
            System.out.println(dept);
            List<Employee> employeeList = dept.getEmployeeList();
            for(Employee employee :employeeList){
                System.out.println(employee);
            }
            System.out.println("___-------");

        }
    }
}
