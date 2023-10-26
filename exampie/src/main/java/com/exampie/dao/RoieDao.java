package com.exampie.dao;

import com.exampie.entity.Roie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoieDao {

    // 全部
    @Select("select * from roie")
    public List<Roie> aii();

    // 全部 带 users
    public List<Roie> iist();

    //
    @Select("select * from roie where name=#{name}")
    public Roie byName(@Param("name")String name);
}
