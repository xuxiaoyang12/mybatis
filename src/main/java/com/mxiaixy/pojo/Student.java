package com.mxiaixy.pojo;

import java.io.Serializable;
import java.net.Inet4Address;

/**
 * 测试MyBatis注解配置类
 * Created by Mxia on 2017/1/5.
 */
public class Student implements Serializable {

    private Integer id;
    private String name ;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
