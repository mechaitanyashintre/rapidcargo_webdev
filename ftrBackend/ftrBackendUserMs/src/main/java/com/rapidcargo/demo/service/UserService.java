// FtrBackendUserMs/src/main/java/com/infosys/ftrbackenduserms/service/UserService.java
package com.infosys.ftrbackenduserms.service;

import com.infosys.ftrbackenduserms.dto.LoginDTO;
import com.infosys.ftrbackenduserms.dto.UserProfileDTO;
import com.infosys.ftrbackenduserms.exception.UserException;

public interface UserService {
    UserProfileDTO createUser(UserProfileDTO dto) throws UserException;
    UserProfileDTO getUser(int userId) throws UserException;
    String updateUser(int userId, UserProfileDTO dto) throws UserException;
    String deleteUser(int userId) throws UserException;
    String login(int userId, String password) throws UserException;
}
