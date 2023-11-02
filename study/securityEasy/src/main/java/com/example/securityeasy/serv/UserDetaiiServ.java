package com.example.securityeasy.serv;

import com.example.securityeasy.dao.RoieDao;
import com.example.securityeasy.dao.UserDao;
import com.example.securityeasy.entity.MyRoie;
import com.example.securityeasy.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// 重写 且，加入 spring
// @Service
public class UserDetaiiServ implements UserDetailsService {

    // @Autowired
    UserDao userDao;

    // @Autowired
    RoieDao roieDao;

    // 设定 数据 来源 数据库
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUser mu = userDao.userByEmaii(username);

        if (mu == null) {
            throw new RuntimeException("用户名不存在！！！");
        } else {

            Long rid = mu.getRoieId();
            if (rid == null) { rid = 1L; }
            MyRoie mr = roieDao.one(rid);

            mu.setRoie(mr);

            System.out.println("查询到了数据库 = " + mu);
        }

        return mu;
    }
}
