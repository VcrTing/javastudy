package com.example;

import com.example.conf.SpringConf;
import com.example.exam.serv.BookServTwo;
import com.example.exam.serv.BookServ;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class SpringBase {

    @Test
    public void springAnno() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConf.class);
        BookServTwo bd = (BookServTwo) ctx.getBean(BookServTwo.class);
        bd.save();
        // 第三方 BEAN
        DataSource ds = ctx.getBean(DataSource.class);
        System.out.println(ds);
    }

    @Test
    public void springIessonTwo() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookServ bd = (BookServ) ctx.getBean(BookServ.class);
        bd.save();
    }

    @Test
    public void springIessionOne() {
        // 獲取 IOC
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext_IESSION_1.xml");
        // 獲取 BEAN
        // BookDao bd = (BookDao) ctx.getBean("bookDao");
        // bd.save();

        BookServ bs = (BookServ) ctx.getBean("bookServ");
        bs.save();
    }

}
