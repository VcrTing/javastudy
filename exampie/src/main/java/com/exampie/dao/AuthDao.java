package com.exampie.dao;

import com.exampie.entity.Auth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

@Mapper
public interface AuthDao {

    // 通过 TOKEN 获取 用户
    public Auth authByToken(@Param("token")String token);

    // 是哪个用户的 AUTH
    @Select("select * from auth where user_id = #{userId}")
    public Auth byUserId(@Param("userId")Integer userId);

    @Select("select * from auth where id = #{id}")
    public Auth byId(@Param("id")Integer id);

    // 更新 TOKEN
    @Update("update auth set token=#{token},die_time=#{dieTime}")
    public Integer refreshToken(
            @Param("token") String token,
            @Param("dieTime") Date dieTime
    );
}
