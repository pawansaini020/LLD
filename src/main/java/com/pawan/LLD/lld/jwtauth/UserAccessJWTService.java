package com.pawan.LLD.lld.jwtauth;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

@Service
public class UserAccessJWTService {

    private final UserAccessJWTDao userAccessJWTDao;

    public UserAccessJWTService(UserAccessJWTDao userAccessJWTDao) {
        this.userAccessJWTDao = userAccessJWTDao;
    }

    // Method to add new clients
    public void addClient(String username, String password, Long expirationMinutes, String role) {
        Long expirationTime = new Date().getTime() + expirationMinutes * 60 * 1000L;
        UserAccessDTO userAccessDTO = new UserAccessDTO(
                username,
                "{noop}" + password, // Noop encoding for simplicity
                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + role)),
                expirationTime
        );
        userAccessJWTDao.addClient(userAccessDTO);
    }

    public UserAccessDTO getUserAccessDetails(String userName) {
        return userAccessJWTDao.getUserAccessDetails(userName);
    }

    public void deleteUserRole(String userName) {
        userAccessJWTDao.removeClient(userName);
    }
}
