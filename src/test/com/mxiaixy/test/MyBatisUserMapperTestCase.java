package com.mxiaixy.test;

import com.mxiaixy.mapper.UserMapper;
import com.mxiaixy.pojo.User;
import com.mxiaixy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * Created by Mxia on 2017/1/4.
 */
public class MyBatisUserMapperTestCase {

    @Test
    public void findAll(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //通过SqlSession获取接口的实现类
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //调用接口中的方法 相当于执行配置文件UserMapper.xml中的sql
        List<User> userList =  userMapper.findAll();//获取数据库中得到所有数据
        for(User user:userList){
            System.out.println(user);
        }

        sqlSession.close();
    }
    @Test
    public void  save(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession(true);

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user= new User();
        user.setUsername("tom是");
        user.setPassword("123123123");

        userMapper.save(user);
        System.out.println(user.getId());//获取自动增长的主键

        sqlSession.close();


    }




}
