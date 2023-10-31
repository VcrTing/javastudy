package com.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.sound.sampled.AudioFormat;

@Component
public class MyDataConf {

    @Value("${my.name}")
    private String name;

    // @Bean
    public String getName() {
        return name; }
}
