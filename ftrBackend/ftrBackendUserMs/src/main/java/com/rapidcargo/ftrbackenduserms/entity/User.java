// FtrBackendUserMs/src/main/java/com/rapidcargo/ftrbackenduserms/entity/User.java
package com.rapidcargo.ftrbackenduserms.entity;

import javax.persistence.*;
import com.rapidcargo.ftrbackenduserms.dto.UserProfileDTO;

@Entity
@Table(name = "ftr_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private String firstName;
    private String lastName;
    private String emailId;
    private Long mobileNumber;
    private String password;
    private String nationality;
    private String passportNumber;
    private String permanentAddress;
    private String officeAddress;
    private Long personalIdentificationNumber;

    // Getters and setters omitted for brevity

    public static User toEntity(UserProfileDTO dto) {
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setEmailId(dto.getEmailId());
        user.setMobileNumber(dto.getMobileNumber());
        user.setPassword(dto.getPassword());
        user.setNationality(dto.getNationality());
        user.setPassportNumber(dto.getPassportNumber());
        user.setPermanentAddress(dto.getPermanentAddress());
        user.setOfficeAddress(dto.getOfficeAddress());
        user.setPersonalIdentificationNumber(dto.getPersonalIdentificationNumber());
        return user;
    }
}
