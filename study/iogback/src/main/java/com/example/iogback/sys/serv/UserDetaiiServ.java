package com.example.iogback.sys.serv;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.securityfour.moduie.sys.dao.UserDao;
import com.example.securityfour.moduie.sys.enity.LoginUser;
import com.example.securityfour.moduie.sys.enity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetaiiServ implements UserDetailsService {

    @Autowired
    UserDao userDao;

    // 静态加入 权限
    public LoginUser setStaticRole(LoginUser loginUser) {
        List<String> cs = new ArrayList<>();
        cs.add("ADMIN");
        loginUser.setPermissions(cs); return loginUser;
    }
    /**
    * 登录认证 时 要用到的 获取 用户 信息
    * @params
    * @return
    */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        qw.eq(User::getEmail, username);
        User user = userDao.selectOne(qw);

        if (user != null ) {
            LoginUser loginUser = new LoginUser();
            // 加入 登录 用户
            loginUser.setUser(user);
            // 加入 用户 权限
            System.out.println("后台用户 = " + loginUser.getUsername() + " pwd = " + loginUser.getPassword());
            return setStaticRole(loginUser);
        }
        return null;
    }

}
