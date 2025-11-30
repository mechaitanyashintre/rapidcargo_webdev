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
