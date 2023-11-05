package com.example.securityeasy.conr;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeConr {

    @GetMapping
    public Map<String, String> home() {
        Map<String, String> mp = new HashMap<>();
        mp.put("name", "张三");
        return mp;
    }

    @GetMapping("/auth/1")
    @PreAuthorize("hasRole('ONE')")
    public Map<String, String> authONE() {
        Map<String, String> mp = new HashMap<>();
        mp.put("name", "权限 ONE");
        return mp;
    }

    @GetMapping("/iogin/success")
    public String succ() {
        return "登录 成功";
    }
}
