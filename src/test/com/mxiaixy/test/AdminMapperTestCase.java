package com.mxiaixy.test;

import com.mxiaixy.mapper.AdminMapper;
import com.mxiaixy.pojo.Admin;
import com.mxiaixy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mxia on 2017/1/5.
 */
public class AdminMapperTestCase {
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
    public  void  findByNameAndJPasswrod(){
        /**
         *  第一种多参数查询方法
         */
        /*AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = adminMapper.findByNameAndPassword("李四","123123");
        System.out.println(admin);*/
        /*
         *第二种多参数查询方法；
         */
       /* AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin admin = adminMapper.findByNameAndPassword("张三","33333");
        System.out.println(admin);*/
        /**
         * 第三种多参数查询传值方法
         * 通过Map集合进行产值
         * sql语句中#{}中的值要和map集合中的键一致
         */
        /*AdminMapper adminMapper = sqlSession .getMapper(AdminMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("name","李四");
        map.put("password","123123");
        Admin admin = adminMapper.findByNameAndPassword(map);
        System.out.println(admin);*/
        /**
         * 第四种 多参数查询
         * 传入一个对象
         *
         */
        AdminMapper adminMapper = sqlSession .getMapper(AdminMapper.class);
        Admin admin = new Admin();
        admin.setPassword("123123");
        admin.setName("李四");
        Admin admin1 = adminMapper.findByNameAndPassword(admin);

    }
}
