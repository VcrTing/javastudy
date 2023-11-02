package com.example.securitytwo.conf;

import com.example.securitytwo.conf.hand.MyLogoutSuccessHandler;
import com.example.securitytwo.serv.UserDetaiiServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConf extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetaiiServ userDetaiiServ; // 重写 UserDetaiiServ
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetaiiServ); // 加入
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //
        http.cors().and().csrf().disable();

        // 解开自己的 登录 方法
        http.authorizeRequests().mvcMatchers("/auth/**", "/pwd/**").permitAll();

        http.authorizeRequests().anyRequest().authenticated();

        http.formLogin();

        http.logout().logoutUrl("/logout").logoutSuccessHandler(new MyLogoutSuccessHandler());
    }


    // 将 默认的登录验证 BEAN 加入 SPRING
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // 加入 BCryptPasswordEncoder 去 SPRING
    /*
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     */
}
