// FtrBackendUserMs/src/main/java/com/rapidcargo/ftrbackenduserms/controller/UserController.java
package com.rapidcargo.ftrbackenduserms.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rapidcargo.ftrbackenduserms.dto.LoginDTO;
import com.rapidcargo.ftrbackenduserms.dto.UserProfileDTO;
import com.rapidcargo.ftrbackenduserms.exception.UserException;
import com.rapidcargo.ftrbackenduserms.service.UserService;

@RestController
@RequestMapping("userprofile")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserProfileDTO> createUser(@RequestBody @Valid UserProfileDTO userProfileDTO) throws UserException {
        return new ResponseEntity<>(userService.createUser(userProfileDTO), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<UserProfileDTO> getUser(@PathVariable int userId) throws UserException {
        return new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable int userId, @RequestBody UserProfileDTO userDto) throws UserException {
        return new ResponseEntity<>(userService.updateUser(userId, userDto), HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable int userId) throws UserException {
        return new ResponseEntity<>(userService.deleteUser(userId), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody @Valid LoginDTO logindto) throws UserException {
        return new ResponseEntity<>(userService.login(logindto.getUserId(), logindto.getPassword()), HttpStatus.OK);
    }
}
