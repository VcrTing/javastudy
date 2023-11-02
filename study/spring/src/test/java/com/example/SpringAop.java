package com.example;

import com.example.aop.exam.UserDao;
import com.example.aop.exam.UserServ;
import com.example.conf.SpringConf;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAop {

    @Test
    public void aop2() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConf.class);
        UserServ userServ = ctx.getBean(UserServ.class);
        userServ.upd(" AA AAA ");
    }

    @Test
    public void aop1() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConf.class);
        UserDao userDao = ctx.getBean(UserDao.class);
        userDao.uptd(1);
    }
}
