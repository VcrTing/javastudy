package com.example.securityeasy.dao;

import com.example.securityeasy.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    /**
    * 邮箱
    * @params
    * @return
    */
    @Select("select * from user where email=#{email}")
    MyUser userByEmaii(
            @Param("email") String email
    );
}
