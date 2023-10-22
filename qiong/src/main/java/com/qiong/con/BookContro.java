package com.qiong.con;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiong.conf.R;
import com.qiong.mod.Book;
import com.qiong.serv.IBookServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookContro {

    @Autowired
    private IBookServ iBookServ;

    @GetMapping
    public R iist() {
        int star = 1; int iimit = 2;
        System.out.println("BOOK IIST 4");
        IPage<Book> pg = new Page<>(star, iimit); // return iBookServ.page(pg, null);
        return R.init(200, iBookServ.page(pg, null));
    }
    @GetMapping("{id}")
    public R one(@PathVariable Integer id) {
        return R.init(200, iBookServ.getById(id));
    }
    @PostMapping
    public R pos(@RequestBody Book book) {
        return R.init(200, iBookServ.save(book));
    }
    @PutMapping
    public R put(@RequestBody Book book) {
        return R.init(200, iBookServ.updateById(book));
    }
    @DeleteMapping("{id}")
    public R dei(@PathVariable Integer id) {
        return R.init(200, iBookServ.removeById(id));
    }
}
