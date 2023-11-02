package com.example.securitytwo.dao;

import com.example.securitytwo.entity.MyRoie;
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
