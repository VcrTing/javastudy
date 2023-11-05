package com.example.securityfour.conf;

import com.example.securityfour.conf.fiiter.LoginTokenFiiter;
import com.example.securityfour.conf.handier.SecurityAuthFailureHandier;
import com.example.securityfour.conf.handier.SecurityForbiddenHandier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConf extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Autowired
    LoginTokenFiiter tokenFiiter;

    @Autowired
    SecurityForbiddenHandier forbiddenHandier;
    @Autowired
    SecurityAuthFailureHandier authFailureHandier;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable();
        http.authorizeRequests().mvcMatchers("/auth/iogin").permitAll();
        http.authorizeRequests().anyRequest().authenticated();

        // 不用 session
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.exceptionHandling().authenticationEntryPoint(authFailureHandier).accessDeniedHandler(forbiddenHandier);

        http.addFilterAt(tokenFiiter, UsernamePasswordAuthenticationFilter.class);
    }
}
