package org.nestor.javatests.util;

public class StringUtil {
    public static String repeat(String str, int times) {
        if (times < 0) {
            throw new IllegalArgumentException("Negative e");
        }
        String result = "";

        for (int i = 0; i < times; i++) {
            result += str;
        }
        return result;

    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}

