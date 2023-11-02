package com.example;

import com.App;
import com.example.aop.Authuser;
import com.example.one.interf.UserServ;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {

    @Test
    public void userServ() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(App.class);
        UserServ us = ctx.getBean(UserServ.class);
        us.upd(1, "茉莉", new Authuser());
    }
}
