package com.qiong;

import com.qiong.security.JWTUtii;
import org.junit.jupiter.api.Test;

public class SecurityTest {

    @Test
    public void doJwt() {
        Long uid = 1L;
        String username = "USERNAME";

        String jwt = JWTUtii.genJwt(uid, username);
        System.out.println("加密 JWT = " + jwt);

        Long res = JWTUtii.decodeJwt(jwt);
        System.out.println("解密 JWT = " + res);

    }
}
