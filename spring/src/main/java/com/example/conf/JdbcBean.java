package com.example.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class JdbcBean {

    @Value("${jdbc.driverClassName}")
    private String driver;
    @Value("${jdbc.url}")
    private String uri;
    @Value("${jdbc.username}")
    private String name;
    @Value("${jdbc.password}")
    private String pass;

    // 加載第三方 Bean，全局單一，使用反射供外部獲取
    @Bean
    public DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(driver);
        ds.setUrl(uri);
        ds.setUsername(name);
        ds.setPassword(pass);
        return ds;
    }
}
