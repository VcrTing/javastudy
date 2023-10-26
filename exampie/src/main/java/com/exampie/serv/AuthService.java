package com.exampie.serv;

import com.exampie.dao.AuthDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    AuthDao authDao;

    // 需要 TOKEN 才能訪問
    public boolean needToken() {
        return true;
    }

    // TOKEN 未過期才能訪問

}
