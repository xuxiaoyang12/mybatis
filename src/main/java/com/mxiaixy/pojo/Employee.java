package com.mxiaixy.pojo;

import java.io.Serializable;

/**
 * 雇员
 * Created by Mxia on 2017/1/4.
 */
public class Employee implements Serializable {
        private Integer id;
        private String empname;
        private Integer deptid;
        private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empname='" + empname + '\'' +
                ", deptid=" + deptid +
                ", dept=" + dept +
                '}';
    }
}
