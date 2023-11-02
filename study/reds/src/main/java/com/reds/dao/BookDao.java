package com.reds.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.reds.mod.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
public interface BookDao extends BaseMapper<Book> {

}
