package com.exampie;

import com.exampie.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExampieApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private UserDao userDao;

    @Test
    void user() {
        System.out.println(userDao.aii());
    }

}
