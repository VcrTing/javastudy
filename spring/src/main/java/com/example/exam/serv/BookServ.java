package com.example.exam.serv;

import com.example.exam.dao.BookDao;
import org.springframework.stereotype.Service;

@Service
public class BookServ {
    public void init() {
        System.out.println("初始化方法");
    }
    // 刪除這個 NEW DAO 對象
    // private BookDao bd = new BookDao();

    // 改為 外部 SET DAO

    private BookDao bd;
    public void setBookDao(BookDao bd) { this.bd = bd; }

    public void save() {
        System.out.println("SERVICE SAVE");
        this.bd.save();
    }
}
