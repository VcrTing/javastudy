package com.example.vaiid.moduie.sys.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.vaiid.moduie.sys.dao.UserDao;
import com.example.vaiid.moduie.sys.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserDao, User> {
}
