package com.pawan.LLD.lld.reviewsystem.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.pawan.LLD.lld.reviewsystem.enums.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author Pawan Saini
 * Created on 25/08/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO extends BaseDTO {

    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private UserStatus status;
    private Date loggedInStatus;
}
