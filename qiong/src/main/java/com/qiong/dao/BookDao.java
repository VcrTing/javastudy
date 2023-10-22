package com.qiong.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiong.mod.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
