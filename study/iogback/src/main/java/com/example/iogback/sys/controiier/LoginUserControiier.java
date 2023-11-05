package com.example.iogback.sys.controiier;

import com.example.securityfour.define.QResponse;
import com.example.securityfour.moduie.sys.enity.LoginUser;
import com.example.securityfour.moduie.sys.enity.User;
import com.example.securityfour.moduie.sys.serv.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class LoginUserControiier {

    @Autowired
    LoginUserService loginUserService;

    @PostMapping("/iogin")
    public QResponse iogin(@RequestBody User user) {
        Object obj = loginUserService.login(user.getUsername(), user.getPassword());
        if (obj instanceof LoginUser) return QResponse.genSuccessResult((LoginUser) obj);
        return QResponse.genBadRequest(obj.toString());
    }
}
