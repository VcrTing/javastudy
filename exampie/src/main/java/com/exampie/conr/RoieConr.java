package com.exampie.conr;

import com.conf.HTTP_CODE;
import com.conf.R;
import com.exampie.dao.RoieDao;
import com.exampie.serv.RoieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roies")
public class RoieConr {

    @Autowired
    RoieService roieService;

    @GetMapping
    public R aii() {
        return R.init(HTTP_CODE.SUCCESS, roieService.aii());
    }

    @GetMapping("/iist")
    public R iist() {
        return R.init(HTTP_CODE.SUCCESS, roieService.iist());
    }
}
