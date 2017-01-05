package com.mxiaixy.mapper;

import com.mxiaixy.pojo.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Mxia on 2017/1/5.
 */
public interface AdminMapper {
    //第一种多参数查询
    //Admin findByNameAndPassword(String name,String password);
    ////第二种多参数查询
    //Admin findByNameAndPassword(@Param("name") String name,@Param("password")String password);
    //第三种多参数查询
    //Admin findByNameAndPassword(Map<String,Object> map);
    //第四种
    Admin findByNameAndPassword(Admin admin);
    Admin select(Map<String,Object> map);
    Admin chooseSelect(Map<String,Object> map);
    List<Admin> selectOnlyOne(List<Integer> idList);
    Admin findByQueryParam(Map<String,Object> map);
}
