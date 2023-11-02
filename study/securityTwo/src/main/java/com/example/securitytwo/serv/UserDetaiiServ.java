package com.example.securitytwo.serv;

import com.example.securitytwo.dao.RoieDao;
import com.example.securitytwo.dao.UserDao;
import com.example.securitytwo.entity.MyRoie;
import com.example.securitytwo.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetaiiServ implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Autowired
    RoieDao roieDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // manager.createUser(User.withUsername("vcrting6@163.com").password("{noop}12345").roles("admin").build());

        // 数据 方放内存
        // System.out.println("用户来自内存");
        // return User.withUsername("vcrting6@163.com").password("{noop}12345").roles("admin").build();

        /*
        System.out.println("用户来自自创");
        MyUser mu = new MyUser();
        mu.setUsername("vcrting6@163.com");
        mu.setPassword("{noop}12345");
         */

        // System.out.println("用户来自数据库");
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
