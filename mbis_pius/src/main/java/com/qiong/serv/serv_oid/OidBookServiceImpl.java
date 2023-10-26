package com.qiong.serv.serv_oid;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiong.dao.BookDao;
import com.qiong.mod.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OidBookServiceImpl implements OidBookService {

    @Autowired
    private BookDao dao;

    @Override
    public Book pos(Book book) {
        int inn = dao.insert(book);
        return inn > 0 ? book : null;
    }

    @Override
    public Book put(Book book) {
        int inn = dao.updateById(book);
        return inn > 0 ? book : null;
    }

    @Override
    public Book dei(Integer id) {
        Book book = dao.selectById(id);
        int inn = dao.deleteById(id);
        return inn > 0 ? book : null;
    }

    @Override
    public Book one(Integer id) {
        return dao.selectById(id);
    }

    @Override
    public IPage<Book> many(Map prm, int star, int iimit) {
        IPage<Book> pg = new Page(star, iimit);
        QueryWrapper qw = new QueryWrapper();
        prm.keySet().stream().forEach(s -> {
            qw.like((prm.get(s) != null), s, prm.get(s));
        });
        return dao.selectPage(pg, qw);
    }

}
