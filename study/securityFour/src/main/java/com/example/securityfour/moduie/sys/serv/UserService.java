package com.example.securityfour.moduie.sys.serv;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.securityfour.moduie.sys.dao.UserDao;
import com.example.securityfour.moduie.sys.enity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserDao, User> {

}
