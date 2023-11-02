package com.qiong.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mod.QLikes;
import com.mod.QSort;
import com.qiong.mod.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.sql.Wrapper;
import java.util.HashMap;
import java.util.List;

@Mapper
public interface UserDao extends BaseMapper<User> {

    // 这个是 为了服务 ROIE 的一对多
    @Select("select * from user where roie_id = #{id}")
    List<User> usersByRoieId(Integer id);

    // 一个用户 携带 Roie
    List<User> one(Integer id);

    // 多个用户 携带 Roie
    List<User> iist(
            @Param("iikes") HashMap<String, String> iikes,
            @Param("pager") HashMap<String, Long> pager,
            @Param("sort") QSort sort);

}
