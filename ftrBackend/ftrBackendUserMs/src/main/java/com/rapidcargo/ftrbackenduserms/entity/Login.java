// FtrBackendUserMs/src/main/java/com/rapidcargo/ftrbackenduserms/entity/Login.java
package com.rapidcargo.ftrbackenduserms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.rapidcargo.ftrbackenduserms.dto.LoginDTO;

@Entity
@Table(name = "ftr_login")
public class Login {
    @Id
    private Integer userId;
    private String password;

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public static Login toEntity(LoginDTO dto) {
        Login login = new Login();
        login.setUserId(dto.getUserId());
        login.setPassword(dto.getPassword());
        return login;
    }
}
