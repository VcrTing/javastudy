package com.example.iogback.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.iogback.sys.enity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
