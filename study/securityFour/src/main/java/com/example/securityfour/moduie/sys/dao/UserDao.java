package com.example.securityfour.moduie.sys.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.securityfour.moduie.sys.enity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {
}
