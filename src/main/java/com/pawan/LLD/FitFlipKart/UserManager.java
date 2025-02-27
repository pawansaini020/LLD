package com.pawan.LLD.FitFlipKart;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pawan Saini
 * Created on 27/02/25.
 */
@Slf4j
public class UserManager {

    private Map<String, User> users;

    public UserManager() {
        this.users = new HashMap<>();
    }

    public void registerUser(String name, int age, String location) {
        users.put(name, new User(name, age, location));
        log.info("Registered new user : {}, {}, {}, {}", name, age, location);
    }

    public User getUser(String userName) {
        return users.get(userName);
    }
}
