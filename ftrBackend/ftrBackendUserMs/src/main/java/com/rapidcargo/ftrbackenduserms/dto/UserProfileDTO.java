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

    public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getOfficeAddress() {
		return officeAddress;
	}

	public void setOfficeAddress(String officeAddress) {
		this.officeAddress = officeAddress;
	}

	public Long getPersonalIdentificationNumber() {
		return personalIdentificationNumber;
	}

	public void setPersonalIdentificationNumber(Long personalIdentificationNumber) {
		this.personalIdentificationNumber = personalIdentificationNumber;
	}

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
