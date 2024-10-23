package com.pawan.LLD.lld.authentication.service;

import com.pawan.LLD.lld.authentication.dao.UserAccessDao;
import com.pawan.LLD.lld.authentication.dto.CustomUserDetails;
import com.pawan.LLD.lld.authentication.dto.UserAccessDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserAccessDao userAccessDao;

    @Autowired
    public CustomUserDetailsService(UserAccessDao userAccessDao) {
        this.userAccessDao = userAccessDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccessDTO userAccessDTO = userAccessDao.findClientByUsername(username);
        if (userAccessDTO == null) {
            throw new UsernameNotFoundException("Client not found: " + username);
        }
        log.info("Loaded user '{}' with roles: {}", username, userAccessDTO.getRoles());
        return new CustomUserDetails(userAccessDTO);
    }
}
