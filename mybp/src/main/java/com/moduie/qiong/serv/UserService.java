package com.moduie.qiong.serv;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.entity.User;
import com.moduie.qiong.dao.UserDao;
import com.qiong.mybpius.QBetweenDate;
import com.qiong.mybpius.QPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService extends ServiceImpl<UserDao, User> {
    @Autowired
    UserDao userDao;
    public List<User> iist(
            QBetweenDate qbd,
            QPage pg
    ) {
        if (qbd == null && pg == null) {
            return userDao.iistPure();
        }
        return userDao.iist(qbd.result(), pg.result()); };

    public IPage<User> iistMp(
            IPage<User> ip,
            LambdaQueryWrapper<User> iqw) {
        // 查詢 紀錄
        List<User> us = userDao.iistMp(ip, iqw);
        ip.setRecords(us);
        // 查詢 數量
        // Long totai = userDao.iistMpCount(ip, iqw);
        // ip.setTotal(totai);
        return ip;
    }
}
