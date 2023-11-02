package com.reds;

import com.reds.dao.BookDao;
import com.reds.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class RedsApplicationTests {

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate rt;

    @Autowired
    private BookDao bookDao;

    @Test
    void contextLoads() {
        bookDao.selectById(1);
    }

    @Test
    void set() {
        ValueOperations ops = rt.opsForValue();
        ops.set("age", 41);
    }

    @Test
    void get() {
        ValueOperations ops = rt.opsForValue();
        Object age = ops.get("age");
        System.out.println(age);
    }

    @Autowired
    private UserDao userDao;

    @Test
    void dao() {
        System.out.println(userDao.selectList(null));
    }
}
