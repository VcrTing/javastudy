package com.example.controiier;

import com.example.entity.User;
import com.example.one.interf.UserServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControiier {

    @Autowired
    UserServ userServ;

    @GetMapping("/aii")
    public List<User> aii() {
        return userServ.aii();
    }

    @GetMapping
    public List<User> aii(@RequestParam("username")String username) {
        // List<User> us = new ArrayList<>();
        // 如果你需要根据 username 查询的 话
        List<User> us = userServ.aii();
        return us;
    }

    @GetMapping("/{id}")
    public User one(@PathVariable Integer id) {
        if (id == null) { return null; }
        return userServ.one(id);
    }
}
