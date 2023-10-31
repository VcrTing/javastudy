package com.conf;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

public class MybatisConf {

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
        SqlSessionFactoryBean b = new SqlSessionFactoryBean();

        b.setDataSource(dataSource);
        b.setTypeAliasesPackage("com.example.entity");

        return b;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer c = new MapperScannerConfigurer();
        c.setBasePackage("com.example.dao");
        return c;
    }
}
