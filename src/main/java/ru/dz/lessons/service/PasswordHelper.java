package ru.dz.lessons.service;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by blvp on 13.03.15.
 */
public class PasswordHelper {

    public static String generateHash(String password, String salt){
        if(password == null) return null;
        if(password.isEmpty()) return "";
        return DigestUtils.md5Hex(password+salt);
    }
}
