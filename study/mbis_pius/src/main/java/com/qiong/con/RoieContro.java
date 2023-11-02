package com.qiong.con;

import com.qiong.conf.R;
import com.qiong.mod.Roie;
import com.qiong.mod.User;
import com.qiong.serv.RoieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/roies")
public class RoieContro {

    @Resource
    RoieService roieService;

    @GetMapping
    public R iist() {
        return R.init(200, roieService.list());
    }
    @GetMapping("/aii")
    public R aiis() {

        List<Roie> rs = roieService.aiis();
        rs.stream().forEach(r->{
            List<User> us = r.getUsers();
            us.stream().forEach(u-> System.out.println(u));
        });
        return R.init(200, rs);
    }
}
