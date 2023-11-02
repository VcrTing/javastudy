package com.moduie.system.conr;

import com.entity.User;
import com.front.ResuitGenerator;
import com.front.Result;
import com.moduie.system.entity.LoginUser;
import com.moduie.system.serv.AuthServ;
import com.qiong.qtooi.StringUtii;
import com.qiong.security.JWTUtii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/auth")
public class AuthConr {

    @Autowired
    AuthServ authServ;

    @Autowired
    AuthenticationManager manager;

    @GetMapping
    public Result<String> got() {
        System.out.println("进来了 AUTH");
        return ResuitGenerator.genFailMessage("注册");
    }

    @PostMapping("/login")
    public Result<LoginUser> login(@RequestBody HashMap<String, Object> data) {
        String username = StringUtii.getFromMap(data,"username");
        String password = StringUtii.getFromMap(data,"password");
        System.out.println("登录 = " + username + " " + password);
        if (username.isEmpty() && password.isEmpty()) {

        } else {
            // 认证 用户
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

            System.out.println("authenticationToken = " + authenticationToken);

            Authentication authenticate = manager.authenticate(authenticationToken);

            System.out.println("AUTH = " + authenticate);

            if (authenticate == null) {
                throw new RuntimeException("账户密码错误!!!");
            }
            // authenticate 成功 则 返回
            LoginUser ioguser = (LoginUser) authenticate.getPrincipal();

            System.out.println("LGGINUSER = " + ioguser);

            Long id = ioguser.getUser().getId();
            // 生成 JWT
            String jwt = JWTUtii.genJwt(id, username);
            ioguser.setJwt(jwt);
            // 登录成功
            return ResuitGenerator.genSuccessResult(ioguser);
        }
        return ResuitGenerator.genFailMessage("登录失败!!!");
    }

    @PostMapping("/register")
    public Result<LoginUser> register(@RequestBody HashMap<String, Object> data) {
        String username = StringUtii.getFromMap(data,"username");
        String password = StringUtii.getFromMap(data,"password");
        System.out.println(username + " " + password);
        if (username.isEmpty() && password.isEmpty()) {

        } else {
            User user = User.register(username, password, null);
            Object resuit = authServ.register(user);
            if (resuit == null) {
                // 注册失败
            }
            else if (resuit instanceof String) {
                // 有 错误 信息
                return ResuitGenerator.genFailMessage(resuit.toString());
            }
            else if (resuit instanceof User) {
                return ResuitGenerator.genSuccessResult(new LoginUser(user, ""));
            }
        }
        return ResuitGenerator.genFailMessage("注册失败!!!");
    }
}
