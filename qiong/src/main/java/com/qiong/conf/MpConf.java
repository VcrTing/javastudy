package com.qiong.conf;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MpConf {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        // 定義 攔截器
        MybatisPlusInterceptor mpi = new MybatisPlusInterceptor();
        mpi.addInnerInterceptor(new PaginationInnerInterceptor());
        return mpi;
    }
}
