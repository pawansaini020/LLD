package com.pawan.LLD.oops;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pawan Saini
 * Created on 10/09/24.
 */
public class Inheritance {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class UserProfileDTO {

        private String name;
        private String gender;
        private String age;
    }

//  Single Inheritance
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class StudentUserProfileDTO extends UserProfileDTO {

        private String qualification;
        private String college;
    }

//  multi level Inheritance
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class CompleteUserProfileDTO extends StudentUserProfileDTO {

        private String address;
    }

    //  Hierarchy Inheritance
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class EmployeeUserProfileDTO extends UserProfileDTO {

        private String designation;
        private Integer experience;
    }

//    Multiple inheritance is not supported in java?
//    To reduce the complexity and simplify the language, multiple inheritance is not supported in java.
//    public class CompleteUserProfileDTO extends StudentUserProfileDTO, EmployeeUserProfileDTO {

//    Has a relationship
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class DoctorUserProfileDTO extends UserProfileDTO {

        private String designation;
        private Integer experience;
    }

//    Is a relationship
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    protected class UserProfileDoa {
        private UserProfileDTO userProfileDTO;
    }

    UserProfileDoa userProfileDoa = new UserProfileDoa(new DoctorUserProfileDTO());
}
