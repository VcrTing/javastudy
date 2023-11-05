package com.example.securityfour.utiis.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Component
public class SecurityTool {

    final static String BEARER = "Bearer ";
    final static String REDIS_KEY = "AUTH_";

    @Autowired
    RedisTool redisTool;

    /**
    * 操作 REDIS
    * @params
    * @return
    */
    public <T> boolean setUserToRedis(Long uid, T data) { redisTool.sot(REDIS_KEY + uid, data); return true; }
    public <T> T getUserFromRedis(Long uid) {
        return redisTool.got(REDIS_KEY + uid);
    }


    /**
    * 获取 登录时 前端 传过来的 BearToken
    * @params
    * @return
    */
    public String getBearToken(HttpServletRequest req) {
        String auth = req.getHeader("Authorization");
        if (StringUtils.hasText(auth)) {
            if (auth.startsWith(BEARER)) return auth.substring(BEARER.length());
        }
        return StringUtils.hasText(req.getHeader("Token")) ? req.getHeader("Token") : req.getHeader("token");
    }

    /**
    * 通过 验证过 TOKEN 的上下文中的 Authentication 拿 用户 信息 (getPrincipal)
    * @params
    * @return
    */
    public Object getPrincipalFromContext() {
        UsernamePasswordAuthenticationToken authenticationToken = getTokenOfCtx();
        return (authenticationToken != null) ? authenticationToken.getPrincipal() : null;
    }

    // 比对 密码
    /**
    * 生成 登录时的 用户名 密码 令牌
    * @params
    * @return
    */
    public UsernamePasswordAuthenticationToken genNamePassToken(String username, String password) {
        System.out.println("生成登录令牌 = " + username + " " + password);
        if (StringUtils.hasText(username) && StringUtils.hasText(password)) {
            return new UsernamePasswordAuthenticationToken(username, password);
        }
        return new UsernamePasswordAuthenticationToken("", "");
    }
    /**
    * 生成 登录 后的 用户 和 权限 令牌
    * @params
    * @return
    */
    public <T> UsernamePasswordAuthenticationToken genAuthRoleToken(T loginUser, Collection<? extends GrantedAuthority> authories) {
        System.out.println("authories = " + authories);
        return new UsernamePasswordAuthenticationToken(loginUser, null, authories);
    }

    /**
    * 保存 令牌 到 当前 请求 上下文
    * @params
    * @return
    */
    public void setTokenOfCtx(UsernamePasswordAuthenticationToken src) {
        SecurityContextHolder.getContext().setAuthentication(src); // return true;
    }

    /**
    * 从 当前 上下文中 获取 令牌
    * @params
    * @return
    */
    public UsernamePasswordAuthenticationToken getTokenOfCtx() {
        return (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
    }
}
