package com.lcms.modules.system.user.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

public class PasswordUtil {

    public static String generatePassword(String password){
        String md5 =new Md5Hash(password, null,5).toHex();
        return md5;
    }
}
