package com.pawan.LLD.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pawan Saini
 * Created on 27/02/25.
 */
@Data
public class UserDTO {

    private String userId;
    private String name;
    private int age;
    private String city;

    public UserDTO(String userId, String name, int age, String city) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getUserId() {
        return userId;
    }
}
