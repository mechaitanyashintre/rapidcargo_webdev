// FtrBackendUserMs/src/main/java/com/rapidcargo/ftrbackenduserms/dto/UserProfileDTO.java
package com.rapidcargo.ftrbackenduserms.dto;

import javax.validation.constraints.*;
import com.rapidcargo.ftrbackenduserms.entity.User;

public class UserProfileDTO {
    private Integer userId;

    @NotNull(message = "{user.firstName.must}")
    @Size(max = 20, message = "{user.firstName.invalid}")
    private String firstName;

    @NotNull(message = "{user.lastName.must}")
    @Size(max = 20, message = "{user.lastName.invalid}")
    private String lastName;

    @NotNull(message = "{user.email.must}")
    @Size(max = 30)
    private String emailId;

    @NotNull(message = "{user.phone.must}")
    @Max(value = 9999999999L, message = "{user.phone.invalid}")
    @Min(value = 1000000000L, message = "{user.phone.invalid}")
    private Long mobileNumber;

    @NotEmpty(message = "{user-password.must}")
    @Size(min = 7, max = 15, message = "{user-password.invalidsize}")
    private String password;

    @NotEmpty(message = "{user.nationality.must}")
    @Size(max = 30)
    private String nationality;

    @NotEmpty(message = "{user-passportNumber.must}")
    @Size(min = 7, max = 12, message = "{user-passportNumber.invalid}")
    private String passportNumber;

    @NotEmpty(message = "{user.permanentAddress.must}")
    @Size(max = 200, message = "{user-permanentAddress.invalid}")
    private String permanentAddress;

    @NotEmpty(message = "{user.officeAddress.must}")
    @Size(max = 200, message = "{user.officeAddress.invalid}")
    private String officeAddress;

    @NotNull(message = "{user-personalIdentificationNumber-must}")
    @Max(value = 999999999999L, message = "{user.personalIdentificationNumber.invalid}")
    @Min(value = 100000000000L, message = "{user.personalIdentificationNumber.invalid}")
    private Long personalIdentificationNumber;

    // Getters and setters omitted for brevity

    public static UserProfileDTO toDto(User user) {
        UserProfileDTO dto = new UserProfileDTO();
        dto.setUserId(user.getUserId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setEmailId(user.getEmailId());
        dto.setMobileNumber(user.getMobileNumber());
        dto.setPassword(user.getPassword());
        dto.setNationality(user.getNationality());
        dto.setPassportNumber(user.getPassportNumber());
        dto.setPermanentAddress(user.getPermanentAddress());
        dto.setOfficeAddress(user.getOfficeAddress());
        dto.setPersonalIdentificationNumber(user.getPersonalIdentificationNumber());
        return dto;
    }
}
