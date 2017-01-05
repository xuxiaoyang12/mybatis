package com.mxiaixy.test;

import com.mxiaixy.mapper.StudentMapper;
import com.mxiaixy.pojo.Student;
import com.mxiaixy.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * 测试MYBatis 注解配置 测试类
 * Created by Mxia on 2017/1/5.
 */
public class StudentMapperTestCase {

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

    /**
     * 查询所有数据
     */
    @Test
    public void findAll(){
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student>  studentList= studentMapper.findAll();
        for(Student student: studentList){
            System.out.println(student);
        }
    }

    /**
     * 添加数据
     */
    @Test
    public void  insert(){
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("小梦梦");
        student.setAddress("北京");
        studentMapper.insert(student);
        sqlSession.commit();
    }
    /**
     * 通过id查询并更改数据
     */
    @Test
    public void update(){
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = studentMapper.findById(1);
        System.out.println(student);
        student.setAddress("周口");
        studentMapper.update(student);
        sqlSession.commit();

    }


}

