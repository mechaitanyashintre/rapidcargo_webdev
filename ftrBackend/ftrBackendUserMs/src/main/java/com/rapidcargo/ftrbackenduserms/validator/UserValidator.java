// FtrBackendUserMs/src/main/java/com/rapidcargo/ftrbackenduserms/validator/UserValidator.java
package com.rapidcargo.ftrbackenduserms.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.rapidcargo.ftrbackenduserms.exception.UserException;

public class UserValidator {

    public Boolean validatePassword(String password) throws UserException {
        Pattern letter = Pattern.compile("[a-zA-Z]");
        Pattern digit = Pattern.compile("[0-9]");
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]-]");

        Matcher hasLetter = letter.matcher(password);
        Matcher hasDigit = digit.matcher(password);
        Matcher hasSpecial = special.matcher(password);

        if (hasLetter.find() && hasDigit.find() && hasSpecial.find()) return true;
        throw new UserException("user-password.invalid");
    }

    public Boolean validatePhoneNumber(Long phoneNumber) throws UserException {
        if (phoneNumber >= 1000000000L && phoneNumber <= 9999999999L) return true;
        throw new UserException("user.phone.invalid");
    }
}
