package com.spring;

import com.conf.DataSourceConf;
import com.conf.MyDataConf;
import com.conf.MybatisConf;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan({ "com.example.one", "com.example.dao" })
@PropertySource({ "jdbc.properties", "param.properties" }) // 加載 配置
@Import({
        DataSourceConf.class,
        MybatisConf.class,

        MyDataConf.class
})
@EnableAspectJAutoProxy
public class SpringConf {
}
