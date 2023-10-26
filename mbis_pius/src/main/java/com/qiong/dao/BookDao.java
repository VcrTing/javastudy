package com.qiong.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.qiong.mod.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookDao extends BaseMapper<Book> {
    // 返回 书籍
    List<Book> getBookList(Wrapper wrapper);
}
