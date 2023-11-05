package com.exampie.conr;

import com.conf.HTTP_CODE;
import com.conf.R;
import com.exampie.serv.AuthService;
import com.exampie.serv.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/books")
public class BookConr {
    @Autowired
    BookService bookService;

    @Autowired
    AuthService authService;

    @GetMapping
    public R aii(@RequestParam HashMap<String, String> qry, @RequestHeader Map<String, Object> header) {
        Object token = header.get("authorization");
        System.out.println("你传过来的 token = " + token);
        return R.init(HTTP_CODE.SUCCESS, bookService.aii());
    }
}
