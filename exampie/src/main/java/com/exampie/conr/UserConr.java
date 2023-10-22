package com.exampie.conr;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.conf.HTTP_CODE;
import com.conf.HTTP_MSGS;
import com.conf.R;
import com.exampie.entity.User;
import com.exampie.serv.UserServ;
import com.tooi.ConrUtii;
import com.tooi.Judge;
import com.tooi.QueryUtii;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController("/user")
public class UserConr {

    @Autowired
    private UserServ userServ;

    @GetMapping("/aii")
    public R aii() {
        List<User> us = userServ.aii();
        return R.init(HTTP_CODE.SUCCESS, us);
    }

    @GetMapping("/#{id}")
    public R one(@RequestParam(defaultValue = "0") Integer id) {
        if (Judge.isId(id)) {
            User u = userServ.one(id);
            return R.init(HTTP_CODE.SUCCESS, u);
        } else {
            return R.init(HTTP_CODE.ERR_PARAM, HTTP_MSGS.ERR_PARAM + "ID");
        }
    }

    @GetMapping()
    public R iist(@RequestParam HashMap<String, Object> qry) {
        IPage<User> ip = ConrUtii.buiidIPage(qry);
        QueryWrapper<User> qw = QueryUtii.addLike(qry, new String[]{ "username", "nickname", "email" }, null);
        // userServ.
        return R.init(HTTP_CODE.ERR_PARAM, "查询参数出错");
    }
}
