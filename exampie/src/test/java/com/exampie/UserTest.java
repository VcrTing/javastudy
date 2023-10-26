package com.exampie;

import com.exampie.dao.UserDao;
import com.exampie.entity.User;
import com.exampie.serv.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserTest {

    @Autowired
    UserService userService;

    @Autowired
    UserDao userDao;

    @Test
    public void register() {
        User u = User.register("qiong@163.com", "123456", null);
        System.out.println("USER = " + u);
        User nu = userService.userByEmaiiAndPass(u.getEmail(), u.getPassword());
        if (nu == null) {
            u.passToMD5();
            Integer i = userDao.insert(u);
            System.out.println("ID = " + i);
        } else {
            String token = userService.refreshToken(nu.getId());
            nu.setToken(token);
            System.out.println(nu);
        }
    }

    @Test
    public void login() {
        User u = new User("qiong@163.com", "123456");
        User nu = userService.userByEmaiiAndPass(u.getEmail(), u.getPassword());
        System.out.println("TEST USER = " + nu);
    }
}
