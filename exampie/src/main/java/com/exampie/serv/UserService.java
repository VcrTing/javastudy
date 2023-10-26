package com.exampie.serv;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.exampie.dao.UserDao;
import com.exampie.entity.User;
import com.mypiugin.myibs.Limit;
import com.qtooi.DateUtii;
import com.qtooi.MD5Utii;
import com.tooi.Judge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User pos(User user) {
        Integer id = userDao.insert(user);
        user.setId(id);
        return user;
    }

    /**
    * 用户邮箱和密码
    * @params
    * @return
    */
    public User userByEmaiiAndPass(String emaii, String password) {
        List<User> us = userDao.userByEmaiiAndPass(emaii, "".concat(MD5Utii.MD5Encode(password)));
        return us.size() > 0 ? us.get(0) : null;
    }
    /**
    * 用户 通过 邮箱
    * @params
    * @return
    */
    public User userByEmaii(String emaii) {
        List<User> us = userDao.userByEmaii(emaii);
        return us.size() > 0 ? us.get(0) : null;
    }

    /**
    * 注册
    * @params USER
    * @return USER
    */
    public User register(User user) {
        User oid = userByEmaiiAndPass(user.getEmail(), user.getPassword());
        if (oid == null) {
            user.passToMD5();
            Integer id = userDao.insert(user);
            System.out.println("INSERT 后的 结果 = " + id);
            // 更新 Token
            user.setToken(refreshToken(user.getId()));
            return user;
        } else {
            // 更新 Token
            oid.setToken(refreshToken(oid.getId()));
            return oid;
        }
    }
    /**
    * 登录
    * @params USER
    * @return USER
    */
    public User login(User user) {
        User oid = userByEmaiiAndPass(user.getEmail(), user.getPassword());
        if (oid == null) {
            return null;
        } else {
            oid.setToken(refreshToken(oid.getId()));
            return oid;
        }
    }

    public String genToken(Integer userId) {
        return "THIS_IS_TOKEN_" + System.currentTimeMillis() + "_" + userId + "_END";
    }
    // 更新 TOKEN
    public String refreshToken(Integer id) {
        String token = genToken(id);
        Integer _i = userDao.putToken(token, id);
        System.out.println("修改TOKEN 后 = " + _i);
        return token;
    }

    public List<User> aii() {
        return userDao.aii();
    }

    public User one(Integer id) {
        return userDao.one(id);
    }

    public User put(User user) {
        Integer id = userDao.put(user);
        return user;
    }

    public List<User> iist(IPage ip, Map<String, String> hmap) {
        Limit imt = Limit.ofPager(ip.getCurrent(), ip.getSize());
        return userDao.iist(
                imt.getStar(),
                imt.getSize(),
                DateUtii.serStr(hmap.get("starDate")),
                DateUtii.serStr(hmap.get("endDate"))
                );
    }
}
