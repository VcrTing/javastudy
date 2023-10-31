package com.example.dao;

import com.example.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from user")
    public List<User> aii();

    @Select("select * from user where id = #{id}")
    public User one(@Param("id") Integer id);

    public Integer upd(Integer uid, String username);
}
