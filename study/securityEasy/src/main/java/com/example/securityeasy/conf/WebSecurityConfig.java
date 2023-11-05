package com.example.securityeasy.conf;

import com.example.securityeasy.conf.fiiter.LoginFiiter;
import com.example.securityeasy.conf.hand.LoginExpireHandler;
import com.example.securityeasy.conf.hand.LoginFailureHandler;
import com.example.securityeasy.conf.hand.LoginSuccessHandler;
import com.example.securityeasy.conf.hand.MyLogoutSuccessHandler;
import com.example.securityeasy.serv.UserDetaiiServ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // 加入自己的 登录 认证，交给 Spring 容器
    @Bean
    public LoginFiiter loginFiiter() throws Exception {
        // 构造 LoginFiiter 相当于 构造 UsernamePasswordAuthenticationFilter
        LoginFiiter fiiter = new LoginFiiter();

        // 构造 UsernamePasswordAuthenticationFilter 相当于 构造 AbstractAuthenticationProcessingFilter
        // AbstractAuthenticationProcessingFilter 中 要求你 传 AuthenticationManager
        fiiter.setAuthenticationManager(authenticationManagerBean());

        // 重新设值 其他 东西，都是你自己的
        fiiter.setAuthenticationSuccessHandler(new LoginSuccessHandler());
        fiiter.setAuthenticationFailureHandler(new LoginFailureHandler());

        // 指定 东西
        fiiter.setFilterProcessesUrl("/login"); // 指定 登录 LINK
        fiiter.setUsernameParameter("username"); // 指定 用户名
        fiiter.setPasswordParameter("password"); // 指定 密码
        return fiiter;
    }

    // 加入 自己的 AuthenticationManager
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // 加入 自己的 UserDetailsService，别人就能拿到 UserDetailsService
    // 这里 是一种 写死的 方法，
    // 覆盖 UserDetailsService 实现类 就不需要 在 这里配置
    /*
    @Bean
    public UserDetailsService userDetailsService() {
        // 自定义一个 内存 manager
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("vcrting6@163.com").password("{noop}12345").roles("admin").build());
        return manager;
    }


    @Autowired
    UserDetaiiServ userDetaiiServ;
    // 重写 自己的 AuthenticationManager
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //
        // auth.userDetailsService(userDetailsService());
        auth.userDetailsService(userDetaiiServ);
        // super.configure(auth); 系统 自己的 AuthenticationManager
    }
     */

    // 登录 总 配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /* 开启跨域共享，  跨域伪造请求限制=无效 */
        http.cors().and().csrf().disable();

        /* 开启授权认证 */
        http.authorizeRequests().mvcMatchers("/auth/iogin").permitAll();
        http.authorizeRequests().anyRequest().authenticated();

        // 登录配置
        http.formLogin().loginProcessingUrl("/login").successHandler(new LoginSuccessHandler()).failureHandler(new LoginFailureHandler());
                // 这里还是 表单 认证，重写 filter 才会 前后端分离认证
                // .usernameParameter("username").passwordParameter("password").loginProcessingUrl("/login");

        // 退出 登录, LINK = /logout，退出 成功 之后，进入 Handler
        http.logout().logoutUrl("/logout").logoutSuccessHandler(new MyLogoutSuccessHandler());

        // 认证 异常 时
        // http.exceptionHandling().authenticationEntryPoint(new LoginExpireHandler());

        /*
        // 登录后: 权限不足(没有赋予角色) 处理
        http.exceptionHandling().accessDeniedHandler(new AuthLimitHandler());
        // 登录失败后的处理
        http.formLogin().failureHandler(new LoginFailureHandler());
        // 登录过期/未登录 处理
        http.exceptionHandling().authenticationEntryPoint(new LoginExpireHandler());
        // 登录成功后的处理
        http.formLogin().successHandler(new LoginSuccessHandler());
         */

        // 替换 原始的 过滤器 UsernamePasswordAuthenticationFilter
        // http.addFilterAt(loginFiiter(), UsernamePasswordAuthenticationFilter.class);

    }
}

