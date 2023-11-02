package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
public class RedisTest {

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate rt;

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
}
