package com.example;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class OtherTest {

    @Test
    public void typeTest() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", "AAAAA");

        Object username = map.get("username");
        if (username instanceof String) {
            System.out.println("STR TYPE");
        }

        Object pass = map.get("pass");
        String res = pass.toString();
        if (res instanceof String) {
            System.out.println("STR TYPE");
        }
    }
}
