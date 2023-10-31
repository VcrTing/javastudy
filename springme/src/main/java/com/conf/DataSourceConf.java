package com.conf;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import javax.sql.DataSource;

public class DataSourceConf {

    // 导入到 spring 时会，通过 @Value 自动 注入
    @Value("jdbc.driverClassName")
    public String driver;

    @Value("jdbc.url")
    public String url;

    @Value("jdbc.username")
    private String username;

    @Value("jdbc.password")
    private String password;

    // 注入 DataSource 數據
    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
