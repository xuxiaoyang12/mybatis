package com.mxiaixy.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * 使用单例模式 让获取sqlSessionFactory 对象获取一次 全局使用
 * 获取SqlSessionFactory工具类
 * Created by Mxia on 2017/1/4.
 */
public class SqlSessionFactoryUtils {
    //私有并静态SqlSessionFactory 对象 使其只能获取一次
    private  static SqlSessionFactory sqlSessionFactory = builderSqlSessionFactory();

    private static SqlSessionFactory builderSqlSessionFactory() {
        try {
            Reader reader = Resources.getResourceAsReader("mybatis.xml");
            return new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            throw new RuntimeException("获取sqlSessionFactory对象错误",e);
        }
    }
    //创建获取SqlSessionFactory对象
    public static  SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
    //获取SqlSession对象
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    //获取SqlSession对象 并传入参数说明是否自动提交事务
    public static SqlSession getSqlSession(Boolean isAutoviews){
        return sqlSessionFactory.openSession(isAutoviews);
    }

}
