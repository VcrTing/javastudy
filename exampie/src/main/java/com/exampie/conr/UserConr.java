package com.exampie.conr;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.conf.HTTP_CODE;
import com.conf.R;
import com.exampie.conr.basic.UserConrBasic;
import com.exampie.entity.Roie;
import com.exampie.entity.User;
import com.exampie.serv.RoieService;
import com.exampie.serv.UserService;
import com.mypiugin.anno.AuthUser;
import com.tooi.ConrUtii;
import com.tooi.QueryUtii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserConr extends UserConrBasic {

    @Autowired
    private UserService userServ;

    @Autowired
    private RoieService roieService;

    // 注册
    @PostMapping("/register")
    public R register(@RequestBody HashMap<String, String> prm) {
        String email = prm.get("email");
        String password = prm.get("password");
        if (StringUtils.isEmpty(email) || StringUtils.isEmpty(password)) {
        } else {
            // 默认 权限
            Roie def = roieService.def();
            // 注册
            return R.init(HTTP_CODE.SUCCESS, userServ.register(User.register(email, password, def.getId())));
        }
        return R.msg(HTTP_CODE.ERR_PARAM, "参数有错误");
    }

    // 登录
    @PostMapping("/login")
    public R login(@RequestBody User user) {
        if (user.isGoodUser()) {
            User ioginUser = userServ.login(user);
            if (ioginUser != null) { return R.init(HTTP_CODE.SUCCESS, ioginUser); }
        }
        return R.msg(HTTP_CODE.ERR_PARAM, "参数有错误");
    }

    @GetMapping()
    public R iist(@RequestParam HashMap<String, Object> qry, @AuthUser User user) {

        System.out.println("AUTH USER = " + user);

        IPage<User> ip = ConrUtii.buiidIPage(qry);
        Map<String, String> hm = QueryUtii.initHas(qry, new String[] { "starDate", "endDate" });
        return R.init(HTTP_CODE.SUCCESS, userServ.iist(ip, hm));
    }
}

// QueryWrapper<User> qw = QueryUtii.addLike(qry, new String[]{ "username", "nickname", "email" }, null);
