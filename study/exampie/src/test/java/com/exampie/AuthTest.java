package com.exampie;

import com.exampie.dao.AuthDao;
import org.example.entity.Auth;
import org.example.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AuthTest {

    @Autowired
    AuthDao authDao;

    static Integer TEST_USER_ID = 20;

    //
    @Test
    public void isTokenDie() {
        Auth ah = authDao.byUserId(TEST_USER_ID);
        System.out.println(ah);
        if (ah != null) {
            System.out.println("是否过期 = " + ah.isTokenExpired());
        }
    }

    //
    @Test
    public void refreshToken() {
        Auth ah = authDao.byUserId(TEST_USER_ID);
        if (ah != null) {
            if (ah.isTokenExpired()) {
                Auth newAuth = ah.refreshToken();
                Integer i = authDao.refreshToken(newAuth.getToken(), newAuth.getDieTime());
                System.out.println("刷新 TOKEN 的结果 = " + i);
            } else {
                System.out.println("TOKEN 没过期");
            }
        } else {
            System.out.println("需要新建 AUTH 数据");
        }
    }

    static String TEST_TOKEN = "TOKEN_1698242388755_USER_ID=20";
    //
    @Test
    public void TokenIsYour() {
        Auth ah = authDao.authByToken(TEST_TOKEN);
        // System.out.println(ah);
        if (ah != null) {
            User u = ah.getUser();
            System.out.println("該 TOKEN 的 用戶 = " + u);
        }
    }
}
