package com.qiong.serv;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiong.dao.BookDao;
import com.qiong.mod.Book;
import org.springframework.stereotype.Service;

@Service
public class BookService extends ServiceImpl<BookDao, Book> {

}
