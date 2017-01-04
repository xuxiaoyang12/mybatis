package com.mxiaixy.test;

import com.mxiaixy.mapper.UserMapper;
import com.mxiaixy.pojo.User;
import com.mxiaixy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by Mxia on 2017/1/4.
 */
public class MyBatisTest {

    @Test
    public void createMybatis(){

        try {
            //首先从classpath中读取myBatis.xml配置文件
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            //获取sqlSessionFactory 对象
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //通过sqlSessionFactory对象 获取SqlSession对象
            SqlSession sqlSession = sessionFactory.openSession();

            //....代码
            //关闭连接
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void  select(){
        //获取sqlSession对象
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        //查询数据
        User user = sqlSession.selectOne("com.mxiaixy.mapper.UserMapper.findById",1);
        System.out.print(user);
        //关闭资源
        sqlSession.close();

    }
    @Test
    public void save(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        User user = new User();
        user.setUsername("小梦梦");
        user.setPassword("521521521");
       // sqlSession.insert("com.mxiaixy.mapper.UserMapper.save",user);
        //使用接口 代理模式
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);//获取接口的实现类
        System.out.println(userMapper);
        userMapper.save(user);//调用实现类中的方法相当于执行配置文件中的sql语句

        sqlSession.commit();//提交事务 如果不提交事务将不会保存数据
        sqlSession.close();
    }
    @Test
    public void  update(){
        SqlSession sqlSession =SqlSessionFactoryUtils.getSqlSession(true);
        //获取y要更新的数据
        User user = sqlSession.selectOne("com.mxiaixy.mapper.UserMapper.findById",3 );
        System.out.println(user);
        user.setPassword("5211314");
        //更新
        sqlSession.update("com.mxiaixy.mapper.UserMapper.update",user);
        sqlSession.close();
    }

    @Test
    public void  del(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession(true);
        sqlSession.delete("com.mxiaixy.mapper.UserMapper.delById",1);
        sqlSession.close();
    }
    @Test
    public void  findAll(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        List<User> userList = sqlSession.selectList("com.mxiaixy.mapper.UserMapper.findAll");

        for(User user : userList){
            System.out.println(user);
        }
        sqlSession.close();
    }
}
