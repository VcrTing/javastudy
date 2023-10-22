package com.exampie.serv;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.exampie.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserServ {
    User pos(User user);
    List<User> aii();
    User one(Integer id);
    User put(User user);

    List<User> iist(IPage ip, QueryWrapper<User> qw);
}
