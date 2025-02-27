package com.pawan.LLD;

import com.pawan.LLD.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Pawan Saini
 * Created on 27/02/25.
 */
@Slf4j
public class UserManager {

    private final ConcurrentHashMap<String, UserDTO> users = new ConcurrentHashMap<>();

    public void registerUser(String id, String name, int age, String city) {
        if(!users.containsKey(id)) {
            users.put(id, new UserDTO(id, name, age, city));
            log.info("USer registered with name: {}, {}", name, id);
        }
    }
}
