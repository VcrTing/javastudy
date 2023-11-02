package com.example.securitytwo.conr;

import com.example.securitytwo.dao.UserDao;
import com.example.securitytwo.entity.MyUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/")
public class HeiioConr {

    @Autowired
    UserDao userDao;

    @GetMapping
    public String heiio() {
        return "HEIIO";
    }

    @GetMapping("/heiio")
    public String heiio2() {
        return "HEIIO 2";
    }

    // 改变用户 密码
    @GetMapping("/pwd/add_bcrypt")
    public String add_bcrypt() {
        MyUser mu = userDao.userByEmaii("vcrting4@163.com");
        String pwd = mu.getPassword();
        if (!pwd.startsWith("{")) {
            pwd = "{bcrypt}" + pwd;
            userDao.userPwd(mu.getId(), pwd);
        }
        return pwd;
    }


    @Autowired
    BCryptPasswordEncoder encoder;

    @GetMapping("/pwd/encode")
    public String pwd_encode() {
        String pwd = "12345";
        pwd = "{bcrypt}" + encoder.encode(pwd);
        return pwd;
    }

    @GetMapping("/pwd/same")
    public String pwd_same() {
        String src = "{bcrypt}$2a$10$58ewXyaj4ZB3IcvEJ2/aq.599zU6jxFpfwMMsFW2MM1UhM8GmVH6q";
        String pwd = "12345";
        return "TRUE";
    }
}
