package com.example.securitytwo.dao;

import com.example.securitytwo.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.security.core.parameters.P;

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

    @Update("update user set password=#{password} where id = #{id}")
    Integer userPwd(
            @Param("id") Long id,
            @Param("password") String password
    );
}
