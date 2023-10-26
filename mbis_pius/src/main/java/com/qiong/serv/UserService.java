package com.qiong.serv;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiong.dao.UserDao;
import com.qiong.mod.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class UserService extends ServiceImpl<UserDao, User> {

    @Resource
    UserDao userDao;

    // User 携带 Roie
    public List<User> one(Integer id) {
        return userDao.one(id);
    }

    // 完整查询 情况
    public List<User> iist(
            HashMap iikes,
            HashMap pager,
            HashMap sort) {
        // List<User> us = userDao.iist(iikes, pager, sort);
        return userDao.iist(iikes, pager, sort);
    }
}
