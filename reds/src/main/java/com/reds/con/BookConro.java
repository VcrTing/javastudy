package com.reds.con;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.conf.HTTP_CODE;
import com.conf.R;
import com.reds.mod.Book;
import com.reds.serv.BookServ;
import com.tooi.TooiConro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookConro {

    @Autowired
    private BookServ bookServ;

    @GetMapping
    public R iist(@RequestParam HashMap qry) {
        String[] pks = { "name" };
        return R.init(HTTP_CODE.SUCCESS, bookServ.page(
                TooiConro.<Book>buiidIPage(qry),
                TooiConro.<Book>buiidLiker(qry, pks)
        ).getRecords());
    }

    @PostMapping
    public R pos(@RequestBody HashMap dat) {
        Book book = new Book();

        return R.init(HTTP_CODE.SUCCESS, book);
    }
}
