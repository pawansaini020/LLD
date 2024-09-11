package com.pawan.LLD.lld.authentication.dto;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
public class CustomUserDetails implements UserDetails {

    private final UserAccessDTO userAccessDTO;

    public CustomUserDetails(UserAccessDTO userAccessDTO) {
        this.userAccessDTO = userAccessDTO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return userAccessDTO.getRoles();
    }

    @Override
    public String getPassword() {
        return userAccessDTO.getPassword();
    }

    @Override
    public String getUsername() {
        return userAccessDTO.getUserName();
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
        return new Date().before(new Date(userAccessDTO.getExpiryTime()));
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
