package com.example;

import com.example.conf.SpringConf;
import com.example.transac.MoneyServ;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.math.BigDecimal;

public class SpringTransc {

    @Test
    public void zhuanQian() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConf.class);
        MoneyServ ms = (MoneyServ) ctx.getBean(MoneyServ.class);
        ms.transfMoney(1, 2, new BigDecimal(100));
    }
}
