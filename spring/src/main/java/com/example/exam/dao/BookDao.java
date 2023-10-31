package com.example.exam.dao;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository("bookDao")
@Scope("singleton")
public class BookDao // implements InitializingBean
{

    @Value("${jdbc.username}")
    private String name;

    public void setName(String name) {
        this.name = name;
        System.out.println("注入的 NAME = " + name);
    }

    public BookDao() {
        System.out.println("用的無參構造方法，私有的 構造方法都能用");
    }

    public boolean save() {
        System.out.println("DAO SAVE NAME = " + name);
        return true;
    }

    // init-method
    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("DAO 初始化。。。");
    }
}
