package com.example.aop.exam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServ {

    @Autowired
    UserDao userDao;

    public void save() {
        userDao.save();
    }

    public void upd(String need_trim) {
        System.out.println("經過 AOP 去掉空格後的 結果 = " + need_trim);
        userDao.uptd(1);
    }
}
