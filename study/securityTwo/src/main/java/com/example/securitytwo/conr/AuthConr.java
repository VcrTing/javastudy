package com.example.securitytwo.conr;

import com.example.securitytwo.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthConr {

    @Autowired
    AuthenticationManager manager;

    @PostMapping("/login")
    public String iogin(@RequestBody HashMap<String, String> data) {
        String username = data.get("username");
        String password = data.get("password");

        if (username.isEmpty() && password.isEmpty()) {

        } else {
            // 认证 用户
            System.out.println("认证 = " + username + " " + password);

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = manager.authenticate(token);

            System.out.println("authentication = " + authentication);

            if (authentication == null) {
                System.out.println("没有 对比 信息");
            } else {

                return "登录 成功";
            }
        }

        return "登录 失败";
    }
}
