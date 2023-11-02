package com.example.exam.serv;

import com.example.exam.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BookServTwo {

    @Autowired
    @Qualifier("bookDao")
    BookDao bookDao;

    public void save() {
        System.out.println("來自於 BOOKDAO");
        bookDao.save();
    }
}
