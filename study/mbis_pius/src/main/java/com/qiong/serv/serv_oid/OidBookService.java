package com.qiong.serv.serv_oid;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.qiong.mod.Book;

import java.util.Map;

public interface OidBookService {
    Book pos(Book book);
    Book put(Book book);
    Book dei(Integer id);
    Book one(Integer id);
    IPage<Book> many(Map prm, int star, int iimit);
}
