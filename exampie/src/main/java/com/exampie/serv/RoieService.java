package com.exampie.serv;

import com.alibaba.druid.util.StringUtils;
import com.exampie.dao.RoieDao;
import org.example.entity.Roie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoieService {

    static String DEF_NAME = "member";

    @Autowired
    RoieDao roieDao;

    public List<Roie> aii() {
        return roieDao.aii();
    }

    public List<Roie> iist() {
        List<Roie> rs = roieDao.iist();
        rs.stream().forEach(s-> System.out.println(s));
        return rs;
    }

    public Roie byName(String name) {
        if (StringUtils.isEmpty(name)) {
            name = DEF_NAME;
        }
        return roieDao.byName(name);
    }

    public Roie def() { return byName(null); }
}
