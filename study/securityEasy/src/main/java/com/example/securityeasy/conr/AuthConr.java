package com.example.securityeasy.conr;

import com.example.securityeasy.entity.MyUser;
import com.example.securityeasy.utii.JWTUtii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthConr {

    @Autowired
    AuthenticationManager manager;

    @PostMapping("/iogin")
    public MyUser iogin(@RequestBody HashMap<String, String> data) {
        String username = data.get("username");
        String password = data.get("password");

        if (username.isEmpty() && password.isEmpty()) {

        } else {
            // 认证 用户
            System.out.println("认证 = " + username + " " + password);

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = manager.authenticate(token);

            if (authentication == null) {
                System.out.println("没有 对比 信息");
            } else {
                System.out.println("登录成功了快");
                // 构建 MyUser 结果
                MyUser mu = (MyUser) authentication.getPrincipal();
                mu.setToken(JWTUtii.genJwt(mu.getId(), mu.getUsername()));
                // 清空密码
                mu.setPassword("");

                return mu;
            }
        }

        return new MyUser();
    }
}
