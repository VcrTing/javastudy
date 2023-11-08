package com.example.iogback.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyTest {

    private String name;

    static Logger logger = LoggerFactory.getLogger(MyTest.class);

    public MyTest() {
        name = "张三";
        logger.info("MyTest 新建");
        logger.trace("MyTest 新建 trace");
    }
}
