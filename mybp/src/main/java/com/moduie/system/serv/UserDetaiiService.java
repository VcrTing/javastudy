package com.moduie.system.serv;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.entity.User;
import com.moduie.qiong.dao.UserDao;
import com.moduie.system.entity.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
// 实现 UserDetailsService
public class UserDetaiiService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 查询 条件
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        qw.eq(User::getEmail, username);

        // 是否有 该 用户
        User user = userDao.selectOne(qw);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名错误");
        }

        // TODO 查询对应的 权限信息

        // 封装

        return new LoginUser(user, "");
    }
}
