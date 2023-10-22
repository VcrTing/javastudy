package com.reds.serv.impi;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.reds.dao.BookDao;
import com.reds.mod.Book;
import com.reds.serv.BookServ;
import org.springframework.stereotype.Service;

@Service
public class BookServImpi extends ServiceImpl<BookDao, Book> implements BookServ {
}
