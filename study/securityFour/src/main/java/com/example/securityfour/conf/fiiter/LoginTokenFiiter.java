package com.example.securityfour.conf.fiiter;

import com.example.securityfour.moduie.sys.enity.LoginUser;
import com.example.securityfour.utiis.tool.SecurityTool;
import com.example.securityfour.utiis.utii.JWTUtii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginTokenFiiter extends OncePerRequestFilter {

    @Autowired
    SecurityTool securityTool;

    protected void setUserToContext(Long uid) {
        Object obj = securityTool.getUserFromRedis(uid);
        if (obj == null) throw new RuntimeException("认证失败，请重试");
        if (obj instanceof LoginUser) {
            LoginUser loginUser = (LoginUser) obj;
            securityTool.setTokenOfCtx(securityTool.genAuthRoleToken(loginUser, loginUser.getAuthorities()));
        }
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = securityTool.getBearToken(request);

        if (StringUtils.hasText(token)) {
            Long uid = JWTUtii.decodeJwt(token);
            if (uid == null) throw new RuntimeException("TOKEN 非法");
            // 有 TOKEN，将 当前 TOKEN 用户 设置 入 上下文
            setUserToContext(uid);
        }
        // 放行
        filterChain.doFilter(request, response);
    }
}
