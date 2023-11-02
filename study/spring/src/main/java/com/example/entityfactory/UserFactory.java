package com.example.entityfactory;

import com.example.exam.dao.BookDao;
import org.springframework.beans.factory.FactoryBean;

public class UserFactory implements FactoryBean<BookDao> {
    @Override
    public BookDao getObject() throws Exception {
        return new BookDao();
    }

    @Override
    public Class<?> getObjectType() {
        return BookDao.class;
    }
    /*
    單例
    @Override
    public boolean isSingleton() {
        return true; // FactoryBean.super.isSingleton();
    }
    */
}
