package com.example.iogback.sys.serv;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.iogback.sys.dao.UserDao;
import com.example.iogback.sys.enity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserDao, User> {

}
