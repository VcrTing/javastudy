package com.reds.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.reds.mod.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<User> {

}
