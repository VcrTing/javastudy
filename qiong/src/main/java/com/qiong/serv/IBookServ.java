package com.qiong.serv;

import com.baomidou.mybatisplus.extension.service.IService;
import com.qiong.mod.Book;

public interface IBookServ extends IService<Book> {

    boolean pos(Book book);
}
