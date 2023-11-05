package com.example.securityfour.utiis.tool;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component("QAuth")
public class SecurityAuthorityTooi {

    public Collection<? extends GrantedAuthority> getAuthoritiesFromContext() {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();;
        return (authenticationToken != null) ? authenticationToken.getAuthorities() : null;
    }
    /*
    public UserDetails getUserDetailsFromContext() {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();;
        return (authenticationToken != null) ? (UserDetails) authenticationToken.getPrincipal() : null;
    }
    */

    public Set<String> getAuthoritiesSet() {
        Collection<? extends GrantedAuthority> cs = getAuthoritiesFromContext();
        return (cs != null) ? AuthorityUtils.authorityListToSet(cs) : new HashSet<>(0);
    }

    // 单个 权限
    public boolean has(String role) { Set<String> as = getAuthoritiesSet(); return as.contains(role); }

    // 多个 权限
    public boolean hasAny(String ...roles) {
        Set<String> as = getAuthoritiesSet();
        for (String r: roles) { if (as.contains(r)) return true; }
        return false;
    }
}
