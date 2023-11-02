package com.qiong.conr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserConr {

    @GetMapping
    public String iist() {
        //
        return "AAA"; // DateUtii.nowString();
    }
}
