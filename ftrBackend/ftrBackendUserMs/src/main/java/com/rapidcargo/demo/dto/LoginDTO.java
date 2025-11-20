// FtrBackendUserMs/src/main/java/com/infosys/ftrbackenduserms/dto/LoginDTO.java
package com.infosys.ftrbackenduserms.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import com.infosys.ftrbackenduserms.entity.Login;

public class LoginDTO {
    private Integer userId;

    @NotEmpty(message = "{user.password.must}")
    @Size(min = 7, max = 15, message = "{user-password.invalidsize}")
    private String password;

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public static LoginDTO toDto(Login login) {
        LoginDTO dto = new LoginDTO();
        dto.setUserId(login.getUserId());
        dto.setPassword(login.getPassword());
        return dto;
    }
}
