package com.moduie.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AuthDao extends BaseMapper<User> {
}
