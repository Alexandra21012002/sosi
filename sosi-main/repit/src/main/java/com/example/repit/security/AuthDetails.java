package com.example.repit.security;

import com.example.repit.entities.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class AuthDetails implements UserDetails {

    private final Authentication authentication;

    public AuthDetails(Authentication authentication) {
        this.authentication = authentication;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null; //права пользователя.
    }

    @Override
    public String getPassword() {
        return this.authentication.getPassword();
    }

    @Override
    public String getUsername() {
        return this.authentication.get_login();
    }

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

    public Authentication getAuthentication(){
        return this.authentication;
    }
}
