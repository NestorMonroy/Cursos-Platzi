package org.nestor.javatests.util;

public class PasswordUtil {
    public static enum SecurityLevel {
        WEAK, MEDIUM, STRONG
    }

    public static Enum<SecurityLevel> assessPassword(String password) {
        if (password.length() < 8) {
            return SecurityLevel.WEAK;
        }
        if (password.matches("[a-zA-Z]+")) {
            return SecurityLevel.WEAK;
        }
        if(password.matches("[a-zA-Z0-9]+")){
            return SecurityLevel.MEDIUM;
        }
        return SecurityLevel.STRONG;
    }
}
