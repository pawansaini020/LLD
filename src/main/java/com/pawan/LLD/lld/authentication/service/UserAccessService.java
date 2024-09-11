package com.pawan.LLD.lld.authentication.service;

import com.pawan.LLD.lld.authentication.dao.UserAccessDao;
import com.pawan.LLD.lld.authentication.dto.UserAccessDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
@Service
public class UserAccessService {

    private final UserAccessDao userAccessDao;

    public UserAccessService(UserAccessDao userAccessDao) {
        this.userAccessDao = userAccessDao;
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
        userAccessDao.addClient(userAccessDTO);
    }

    public UserAccessDTO getUserAccessDetails(String userName) {
        return userAccessDao.getUserAccessDetails(userName);
    }

    public void deleteUserRole(String userName) {
        userAccessDao.removeClient(userName);
    }
}
