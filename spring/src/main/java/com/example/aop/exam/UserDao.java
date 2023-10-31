package com.example.aop.exam;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public void save() {
        System.out.println("保存");
    }

    public boolean uptd(Integer id) {
        System.out.println("修改 ID = " + id);
        return id > 0;
    }

}
