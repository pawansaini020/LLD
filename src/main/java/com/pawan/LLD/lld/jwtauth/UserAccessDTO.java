package com.pawan.LLD.lld.jwtauth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAccessDTO {

    private String userName;
    private String password;
    private Collection<? extends GrantedAuthority> roles;
    private long expiryTime;
}
