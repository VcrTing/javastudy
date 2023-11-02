package com.example.one.interf;

import com.example.aop.Authuser;
import com.example.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserServ {

    /**
    * 查询 全部
    * @params
    * @return
    */
    public List<User> aii();

    /**
    * 一个 用户
    * @params
    * @return
    */
    public User one(Integer id);

    public void upd(Integer uid, String username, Authuser authuser);
}
