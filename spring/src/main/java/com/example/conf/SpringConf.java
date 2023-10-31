package com.example.conf;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.example")
@PropertySource({ "jdbc.properties" })
@Import({ JdbcBean.class, TransacBean.class })
@EnableAspectJAutoProxy // 啟動 AOP 自動代理
@EnableTransactionManagement // 啟動 事務管理器
public class SpringConf {

}
