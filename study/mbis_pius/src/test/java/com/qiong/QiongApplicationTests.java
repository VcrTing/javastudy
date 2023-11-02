package com.qiong;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiong.dao.BookDao;
import com.qiong.mod.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class QiongApplicationTests {

    @Autowired
    private BookDao bd;

    @Test
    void contextLoads() {
    }

    @Test
    void testPage() {
        IPage pg = new Page(1, 5);
        bd.selectPage(pg, null);
        Long toi = pg.getTotal();
        List<Book> bks = pg.getRecords();
        bks.stream().forEach(s -> System.out.println(s));
    }

    @Test
    void testQuery() {
        String search = "黑";
        QueryWrapper<Book> qw = new QueryWrapper<>();
        // LambdaQueryWrapper iqw = new LambdaQueryWrapper();
        qw.like((search != null), "name", search);
        // iqw.like((search != null), Book::getName, search);
        bd.selectList(qw);
    }

    @Test
    void testUser() {
        // List<User> us = userServ.list(null);
        // us.stream().forEach(s-> System.out.println(s));
    }
}
