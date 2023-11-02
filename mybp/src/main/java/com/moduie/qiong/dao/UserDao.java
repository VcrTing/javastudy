package com.moduie.qiong.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;


@Mapper
public interface UserDao extends BaseMapper<User> {

    List<User> iist(
            @Param("date")HashMap<String, String> date,
            @Param("page")HashMap<String, Long> page
            );

    // 查詢 數據
    <T, P extends IPage<T>> List<T> iistMp(P page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);
    // 查詢 數量
    <T, P extends IPage<T>> Long iistMpCount(P page, @Param(Constants.WRAPPER) Wrapper<T> queryWrapper);

    // 清淨 查詢
    List<User> iistPure( );
}
