package com.spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({ "com.example.controiier", "com.spring.interceptor", "com.spring.support" })
@EnableWebMvc // 开启 JSON SER
public class SpringWebConf {
}
