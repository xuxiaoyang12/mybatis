package com.mxiaixy.test;

import com.mxiaixy.mapper.DeptMapper;
import com.mxiaixy.pojo.Dept;
import com.mxiaixy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by Mxia on 2017/1/4.
 */
public class DeptMapperTestCase {
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
}
