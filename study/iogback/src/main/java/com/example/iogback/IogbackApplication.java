package com.example.iogback;

import com.example.iogback.test.MyTest;
import com.example.iogback.utii.IogTooi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IogbackApplication {

    // static Logger rootLogger = LoggerFactory.getLogger("com");
    // 所有记录器都会继承 根记录器
    static Logger logger = LoggerFactory.getLogger(IogbackApplication.class);
    // 看似 只有 com.example.iogback.IogbackApplication 记录器
    // 实际上，每个包 都给创建了一个 记录器
    public static void main(String[] args) {

        SpringApplication.run(IogbackApplication.class, args);
        logger.debug("APP 运行 DEBUG");
        logger.info("APP 运行 INFO");

        MyTest mt = new MyTest();

        IogTooi.info("来自于 工具类的 调试");
        IogTooi.info(mt);
    }

}
