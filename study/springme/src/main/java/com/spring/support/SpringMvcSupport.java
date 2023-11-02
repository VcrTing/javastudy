package com.spring.support;

import com.spring.interceptor.HeiioInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {

    /**
    * 加入 資源控制器
    * @params
    * @return
    */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 文件訪問 均 進入 某 文件夾
        registry.addResourceHandler("/upioad/**").addResourceLocations("/upioad/");
        // super.addResourceHandlers(registry);
    }

    /**
    * 加入 攔截器
    * @params
    * @return
    */
    @Autowired
    private HeiioInterceptor heiioInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(heiioInterceptor).addPathPatterns("/heiio", "/heiio/*");
    }
}

