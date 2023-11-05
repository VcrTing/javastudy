package com.exampie.conr.basic;

import com.conf.HTTP_CODE;
import com.conf.HTTP_MSGS;
import com.conf.R;
import com.exampie.entity.User;
import com.exampie.serv.UserService;
import com.tooi.Judge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
public class UserConrBasic {

    @Autowired
    UserService serv;

    // 列出所有
    @GetMapping("/aii")
    public R aii() {
        List<User> us = serv.aii();
        return R.init(HTTP_CODE.SUCCESS, us);
    }

    // 查询一个
    @GetMapping("/{id}")
    public R one(@RequestParam(defaultValue = "0") Integer id) {
        if (Judge.beint(id) != 0) {
            User u = serv.one(id);
            return R.init(HTTP_CODE.SUCCESS, u);
        } else {
            return R.init(HTTP_CODE.ERR_PARAM, HTTP_MSGS.ERR_PARAM.v + "ID = " + id);
        }
    }

    // 新增

    // 修改

    // 删除
}
