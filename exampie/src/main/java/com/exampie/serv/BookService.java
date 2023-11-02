package com.exampie.serv;

import com.exampie.dao.BookDao;

import org.example.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    public List<Book> aii() {

        return bookDao.aii();
    }
}
