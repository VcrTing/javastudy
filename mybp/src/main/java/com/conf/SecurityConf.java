package com.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Configuration
public class SecurityConf extends WebSecurityConfigurerAdapter {
    private String[] AUTH_WHITE_LIST = new String[] {
            "/auth",
            "/auth/**",
            "/users/**"
    };
    private String[] AUTH_ADMIN_LIST = new String[] {
            "/book",
            "/book/**"
    };

    // 配置 spring.security
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                // 定义 放行 哪些 LINK
                .antMatchers(AUTH_WHITE_LIST).permitAll()
                // 定义 哪些 LINK 需要 ADMIN 权限
                .antMatchers(AUTH_ADMIN_LIST).hasAuthority("ADMIN");

        // 除了上方的 LINK 之外，其他 LINK，全需要 验证
        http.authorizeHttpRequests().anyRequest().authenticated();

        // 关闭 csrf 验证
        http.csrf().disable()
        // 关闭 session 获取 security context
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // 弹出 登录
        http.logout().logoutUrl("/auth/logout").logoutSuccessUrl("/auth/login");

        // 什么认证
        // .and().formLogin().and().httpBasic()


        // 定义登录 页面
        // http.formLogin().loginPage("/login.html").loginProcessingUrl("/auth/login").defaultSuccessUrl("/index");

        // 结束
        System.out.println("完成 SECURITY 配置");
    }

    // 载入 登录验证 BEAN
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // 加入 BCryptPasswordEncoder 去 SPRING
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//
}
