package com.example.cake.utils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class ValidUtils {
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNumber(String str) {
        return str.matches("\\d+");
    }

    public static boolean isEmail(String str) {
        return str.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$");
    }

    public static boolean isPhone(String str) {
        return str.matches("^[0-9]{10,11}$");
    }

    public static boolean isPassword(String str) {
        return str.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }

    public static String checkPassword(String str) {
        if(str.length() < 8) return "Password must be at least 8 characters";
        if(!str.matches(".*[0-9].*")) return "Password must contain at least one digit";
        if(!str.matches(".*[a-z].*")) return "Password must contain at least one lowercase letter";
        if(!str.matches(".*[A-Z].*")) return "Password must contain at least one uppercase letter";
        if(!str.matches(".*[@#$%^&+=].*")) return "Password must contain at least one special character";
        return null;
    }

    public static boolean isName(String str) {
        return str.matches("^[a-zA-Z\\s]+$");
    }

    public static boolean isAddress(String str) {
        return str.matches("^[#.0-9a-zA-Z\\s,-]+$");
    }

    public static boolean isNotice(String str){
        return str.matches("^[a-zA-Z0-9\\s,.!]+$");
    }
    public static String pareCode(String str) throws UnsupportedEncodingException {
        return new String(str.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

}
