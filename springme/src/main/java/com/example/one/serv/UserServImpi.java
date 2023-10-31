package com.example.one.serv;

import com.example.aop.Authuser;
import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.one.interf.UserServ;
import com.conf.MyDataConf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServImpi implements UserServ {

    @Autowired
    UserDao userDao;

    @Autowired
    MyDataConf myDataConf;

    @Override
    public List<User> aii() {
        return userDao.aii();
    }

    @Override
    public User one(Integer id) {
        return userDao.one(id);
    }

    @Override
    public void upd(Integer uid, String username, Authuser authuser) {
        Integer res1 = userDao.upd(1, "QIONG");
        System.out.println("----");
        Integer res2 = userDao.upd(2, "VCRTING");
        System.out.println("自動注入的 我的 數據 = " + myDataConf.getName());
    }
}
