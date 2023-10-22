package com.qiong.serv;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiong.dao.BookDao;
import com.qiong.mod.Book;
import org.springframework.stereotype.Service;

@Service
public class IBookServImpi extends ServiceImpl<BookDao, Book> implements IBookServ {

    // 我自己的 方法
    @Override
    public boolean pos(Book book) {
        return false;
    }
}
