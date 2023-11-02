package com.qiong.con;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qiong.conf.R;
import com.qiong.mod.Book;
import com.qiong.serv.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/books")
public class BookContro {
    @Resource
    private BookService bookService;

    @GetMapping
    public R iist() {
        IPage<Book> pg = new Page<>(1, 3);
        return R.init(200, bookService.page(pg, null));
    }
    @GetMapping("{id}")
    public R one(@PathVariable Integer id) {
        return R.init(200, bookService.getById(id));
    }
    @PostMapping
    public R pos(@RequestBody Book book) {
        return R.init(200, bookService.save(book));
    }
    @PutMapping
    public R put(@RequestBody Book book) {
        return R.init(200, bookService.updateById(book));
    }
    @DeleteMapping("{id}")
    public R dei(@PathVariable Integer id) {
        return R.init(200, bookService.removeById(id));
    }
}
