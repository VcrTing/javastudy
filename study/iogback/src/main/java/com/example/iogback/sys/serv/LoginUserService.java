package com.example.iogback.sys.serv;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.securityfour.moduie.sys.dao.UserDao;
import com.example.securityfour.moduie.sys.enity.LoginUser;
import com.example.securityfour.moduie.sys.enity.User;
import com.example.securityfour.utiis.tool.SecurityTool;
import com.example.securityfour.utiis.utii.JWTUtii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class LoginUserService extends ServiceImpl<UserDao, User> {

    @Autowired
    UserDao userDao;

    @Autowired
    SecurityTool securityTool;

    @Autowired
    AuthenticationManager manager;

    private void storeUser(Long uid, LoginUser loginUser) {
        securityTool.setUserToRedis(uid, loginUser);
    }
    private LoginUser killPassword(LoginUser loginUser) {
        loginUser.getUser().setPassword(""); return loginUser;
    }
    private LoginUser groupLoginUser(LoginUser loginUser) {
        User user = loginUser.getUser();
        if (user == null) return null; storeUser(user.getId(), loginUser);
        loginUser.setToken(JWTUtii.genJwt(user.getId(), user.getEmail()));
        return killPassword(loginUser);
    }

    /**
     * 登录
     * @params
     * @return
     */
    public Object login(String name, String pass) {
        if (StringUtils.hasText(name) && StringUtils.hasText(pass)) {
            UsernamePasswordAuthenticationToken authenticationToken = securityTool.genNamePassToken(name, pass);
            Authentication authentication = manager.authenticate(authenticationToken);
            if (authentication == null) return "用户名或密码错误，认证失败";
            Object loginUser = authentication.getPrincipal();
            return (loginUser == null) ? "用户名或密码错误，认证失败" : groupLoginUser((LoginUser) loginUser);
        }
        return "用户名或密码为空";
    }
}
