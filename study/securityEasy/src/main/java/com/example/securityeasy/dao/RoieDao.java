package com.example.securityeasy.dao;

import com.example.securityeasy.entity.MyRoie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RoieDao {

    @Select("select * from roie where id=#{id}")
    MyRoie one(
            @Param("id") Long id
    );
}
