package com.pawan.LLD.lld.splitwise;

import lombok.Data;

/**
 * @author Pawan Saini
 * Created on 20/02/25.
 */
@Data
public class User {

    private Long userId;
    private String name;
    private String email;
    private String phone;

    public User(Long userId, String name, String email, String phone) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
}
