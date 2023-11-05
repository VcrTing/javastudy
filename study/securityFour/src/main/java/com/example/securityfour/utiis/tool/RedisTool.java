package com.example.securityfour.utiis.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

@Component
public class RedisTool {

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate rt;

    public <T> boolean sot(String key, T data) {
        ValueOperations vo = rt.opsForValue();
        vo.set(key, data);
        return true;
    }

    public <T> boolean sotExpire(String key, T data, Long expireTime) {
        ValueOperations vo = rt.opsForValue();
        vo.set(key, data, expireTime);
        return true;
    }

    public <T> T got(String key) {
        try {
            ValueOperations vo = rt.opsForValue();
            return (T) vo.get(key);
        } catch (Exception e) { return null; }
    }

    public void dei(String key) { rt.delete(key); }
}
