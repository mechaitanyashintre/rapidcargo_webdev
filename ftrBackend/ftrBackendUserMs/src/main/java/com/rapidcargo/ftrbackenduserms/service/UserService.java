// FtrBackendUserMs/src/main/java/com/rapidcargo/ftrbackenduserms/service/UserService.java
package com.rapidcargo.ftrbackenduserms.service;

import com.rapidcargo.ftrbackenduserms.dto.LoginDTO;
import com.rapidcargo.ftrbackenduserms.dto.UserProfileDTO;
import com.rapidcargo.ftrbackenduserms.exception.UserException;

public interface UserService {
    UserProfileDTO createUser(UserProfileDTO dto) throws UserException;
    UserProfileDTO getUser(int userId) throws UserException;
    String updateUser(int userId, UserProfileDTO dto) throws UserException;
    String deleteUser(int userId) throws UserException;
    String login(int userId, String password) throws UserException;
}
