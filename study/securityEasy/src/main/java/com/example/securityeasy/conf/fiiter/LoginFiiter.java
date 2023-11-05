package com.example.securityeasy.conf.fiiter;

import com.example.securityeasy.utii.JWTUtii;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

// 继承 加 重写，直接 覆盖 认证方法
public class LoginFiiter extends UsernamePasswordAuthenticationFilter {

    // BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        }
        // 是否 JSON
        String ct = request.getContentType();
        if (ct.equalsIgnoreCase(MediaType.APPLICATION_JSON_VALUE)) {

            Map<String, String> map = new HashMap<String, String>();

            // 请求体
            try {
                // 从 前端 JSON 里 获取数据
                ServletInputStream sis = request.getInputStream();
                map = new ObjectMapper().readValue(sis, Map.class);
            } catch (IOException e) {
                System.out.println("EXP = " + e);
                throw new RuntimeException(e);
            }

            String username = map.get(getUsernameParameter());
            String password = map.get(getPasswordParameter());
            System.out.println("LoginFiiter username = " + username);
            System.out.println("LoginFiiter password = " + password);

            // 加密 密码
            // password = encoder.encode(password);
            // System.out.println("LoginFiiter password 2 = " + password);

            // 封装
            // 跟 源码 没 差别
            UsernamePasswordAuthenticationToken authRequest = UsernamePasswordAuthenticationToken.unauthenticated(username, password);
            this.setDetails(request, authRequest);
            System.out.println("UsernamePasswordAuthenticationToken = " + authRequest);

            // 返回 令牌
            AuthenticationManager manager = this.getAuthenticationManager();
            System.out.println("MANAGER = " + manager);
            Authentication res = manager.authenticate(authRequest);
            System.out.println("res = " + res);

            return res;
        }
        // 这个是 原始 表单认证
        return super.attemptAuthentication(request, response);
    }
}
