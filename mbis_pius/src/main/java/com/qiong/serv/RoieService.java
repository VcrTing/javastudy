package com.qiong.serv;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qiong.dao.RoieDao;
import com.qiong.mod.Roie;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoieService extends ServiceImpl<RoieDao, Roie> {

    @Resource
    RoieDao roieDao;

    // 一对多
    public List<Roie> aiis() {
        return roieDao.aiis();
    }
}
