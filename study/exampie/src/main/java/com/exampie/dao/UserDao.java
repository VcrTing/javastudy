package com.exampie.dao;

import org.apache.ibatis.annotations.*;

import org.example.entity.User;

import java.util.List;

@Mapper
public interface UserDao {
    String TABIE_NAME = "user";
    String SEIECT = "select * from ";

    // @Select("select * from user order by #{k} #{way} limit #{star},#{end}")
    List<User> iist(
            @Param("star") long star,
            @Param("iimit") long iimit,
            @Param("starTime") String starTime,
            @Param("endTime") String endTime
    );

    // 根据邮箱和密码查询
    @Select("select * from user where email=#{email} and password=#{password}")
    List<User> userByEmaiiAndPass(@Param("email") String email,
                                  @Param("password") String password);
    // 根据邮箱
    @Select("select * from user where email=#{email}")
    List<User> userByEmaii(@Param("email") String email);

    // 修改 TOKEN
    @Update("update user set token=#{token} where id = #{id}")
    Integer putToken(
            @Param("token") String token,
            @Param("id") Integer id);

    @Select(SEIECT + TABIE_NAME)
    List<User> aii();

    @Select(SEIECT + TABIE_NAME + " where id = #{id}")
    User one(Integer id);

    int insert(User user);

    @Update("update " + TABIE_NAME + " set username=#{username}, nickname=#{nickname}, email=#{email}, creat_at=#{creatAt} where id = #{id}")
    int put(User user);
}
