package com.moduie.system.serv;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.User;
import com.moduie.system.dao.AuthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServ extends ServiceImpl<AuthDao, User> {

    @Autowired
    AuthDao authDao;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    // 登录
    public Object login(User user) {
        return null;
    }

    // 注册
    public Object register(User user) {

        if (user.isGoodUser()) {

            // 开启 查询
            LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
            qw.eq(User::getEmail, user.getEmail());
            // 查询 相同 邮箱的 用户
            User dbuser = authDao.selectOne(qw);

            if (dbuser != null) {
                // 已存在
                if (passwordEncoder.matches(user.getPassword(), dbuser.getPassword())) {
                    // 密码 通过 校验
                } else {
                    // 密码 校验失败
                    // 已存在 用户名，但是 用户 密码输入错误
                    return "已存在该用户名，但是密码错误！！！";
                }
            } else {
                // 不存在
                // 执行 注册
                // 加密 传来的 密码
                // String ecoPass = passwordEncoder.encode(user.getPassword());
                // user.setPassword(ecoPass);
                // 插入 数据
                int res = authDao.insert(user);
                System.out.println("注册的 结果 = " + res);

                return user;
            }

            // TODO 执行 登录
        }
        return null;
    }

}
