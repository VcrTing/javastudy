package com.qiong.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiong.mod.Roie;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoieDao extends BaseMapper<Roie> {

    // 一对多
    public List<Roie> aiis();
}
