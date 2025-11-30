// FtrBackendUserMs/src/main/java/com/rapidcargo/ftrbackenduserms/service/UserServiceImp.java
package com.rapidcargo.ftrbackenduserms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.rapidcargo.ftrbackenduserms.dto.LoginDTO;
import com.rapidcargo.ftrbackenduserms.dto.UserProfileDTO;
import com.rapidcargo.ftrbackenduserms.entity.Login;
import com.rapidcargo.ftrbackenduserms.entity.User;
import com.rapidcargo.ftrbackenduserms.exception.UserException;
import com.rapidcargo.ftrbackenduserms.repository.LoginRepository;
import com.rapidcargo.ftrbackenduserms.repository.UserRepository;
import com.rapidcargo.ftrbackenduserms.validator.UserValidator;

@Service
@PropertySource("classpath:ValidationMessages.properties")
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private Environment env;

    @Override
    public UserProfileDTO createUser(UserProfileDTO dto) throws UserException {
        UserValidator validator = new UserValidator();
        validator.validatePassword(dto.getPassword());

        User user = User.toEntity(dto);
        userRepository.save(user);

        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setUserId(user.getUserId());
        loginDTO.setPassword(user.getPassword());
        Login login = Login.toEntity(loginDTO);
        loginRepository.save(login);

        return UserProfileDTO.toDto(user);
    }

    @Override
    public UserProfileDTO getUser(int userId) throws UserException {
        Optional<User> userOptional = userRepository.findById(userId);
        User user = userOptional.orElseThrow(() -> new UserException(env.getProperty("user.notFound")));
        return UserProfileDTO.toDto(user);
    }

    @Override
    public String updateUser(int userId, UserProfileDTO dto) throws UserException {
        try {
            UserValidator validator = new UserValidator();
            validator.validatePhoneNumber(dto.getMobileNumber());

            Optional<User> userOptional = userRepository.findById(userId);
            User user = userOptional.orElseThrow(() -> new UserException(env.getProperty("user.notFound")));

            user.setMobileNumber(dto.getMobileNumber());
            user.setOfficeAddress(dto.getOfficeAddress());
            user.setPermanentAddress(dto.getPermanentAddress());

            userRepository.save(user);

            return env.getProperty("user.update.success") + userId;
        } catch (Exception e) {
            throw new UserException(env.getProperty("user.update.fail"));
        }
    }

    @Override
    public String deleteUser(int userId) throws UserException {
        try {
            Optional<User> userOptional = userRepository.findById(userId);
            User user = userOptional.orElseThrow(() -> new UserException(env.getProperty("user.notFound")));
            userRepository.delete(user);

            Optional<Login> loginOptional = loginRepository.findById(userId);
            loginOptional.ifPresent(loginRepository::delete);

            return env.getProperty("user.delete.success") + userId;
        } catch (Exception e) {
            throw new UserException(env.getProperty("user.notFound"));
        }
    }

    @Override
    public String login(int userId, String password) throws UserException {
        try {
            Optional<Login> loginOptional = loginRepository.findById(userId);
            Login login = loginOptional.orElseThrow(() -> new UserException(env.getProperty("user.login.failure")));

            if (login.getPassword().equals(password)) {
                return env.getProperty("user.login.success");
            } else {
                throw new UserException(env.getProperty("user.login.failure"));
            }
        } catch (Exception e) {
            throw new UserException(env.getProperty("user.login.failure"));
        }
    }
}
