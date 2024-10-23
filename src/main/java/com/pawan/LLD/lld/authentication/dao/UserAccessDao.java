package com.pawan.LLD.lld.authentication.dao;

import com.pawan.LLD.lld.authentication.dto.UserAccessDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class UserAccessDao {

    private final Map<String, UserAccessDTO> USER_ACCESS_MAP = new ConcurrentHashMap<>();

    public UserAccessDTO findClientByUsername(String username) {
        return USER_ACCESS_MAP.get(username);
    }

    public void addClient(UserAccessDTO userAccessDTO) {
        USER_ACCESS_MAP.put(userAccessDTO.getUserName(), userAccessDTO);
        log.info("New user access added in system with: {}", userAccessDTO);
    }

    public void removeClient(String username) {
        USER_ACCESS_MAP.remove(username);
        log.info("User access removed in system with: {}", username);
    }

    public UserAccessDTO getUserAccessDetails(String userName) {
        return USER_ACCESS_MAP.get(userName);
    }
}
