package com.api.ong.utils;

import org.springframework.web.server.ResponseStatusException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class Utils {

    public static final String RESOURCE_NOT_FOUND = "Resource not found";
    public static final String ID_CANT_BE_NULL = "Id can't be null";
    public static final String NO_RECORDS_FOUND = "No records found";
    public static final String RESOURCE_ALREADY_EXISTS = "Resource already exists";
    public static final String USER_OR_ONG_NOT_FOUND = "User or Ong not found";
    public static final String PASSWORD_CANT_BE_ENCRYPTED = "Password can't be encrypted";
    public static final String EMAIL_OR_PASSWORD_INCORRECT = "E-mail or password incorrect";

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static String encryptPassword(String password) {
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            byte[] passwordBytes = algorithm.digest(password.getBytes(UTF_8));
            StringBuilder passwordHexadecimal = new StringBuilder();
            for (byte b : passwordBytes) {
                passwordHexadecimal.append(String.format("%02X", 0xFF & b));
            }
            return passwordHexadecimal.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new ResponseStatusException(BAD_REQUEST, PASSWORD_CANT_BE_ENCRYPTED);
        }
    }
}
