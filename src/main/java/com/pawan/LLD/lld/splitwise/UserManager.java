package com.pawan.LLD.lld.splitwise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pawan Saini
 * Created on 20/02/25.
 */
public class UserManager {

    private Map<Long, User> USERS = new HashMap<>();

    public User createUser(Long userId, String name, String email, String phone) {
        User user = new User(userId, name, email, phone);
        USERS.put(userId, user);
        return user;
    }
}
