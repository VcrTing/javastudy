package com.moduie.system.entity;

import com.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUser implements UserDetails {

    private User user;
    private String jwt;

    // 返回权限信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    // 获取 密码
    // 登录输入的密码，与你这里提供的密码进行比较
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    // 获取 用户名
    @Override
    public String getUsername() {
        return user.getEmail();
    }

    // 是否没过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
