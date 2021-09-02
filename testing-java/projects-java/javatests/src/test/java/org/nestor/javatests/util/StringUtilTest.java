package org.nestor.javatests.util;

public class StringUtilTest {

    public static void main(String[] args) {
        //System.out.println(result);
        assertEquals(StringUtil.repeat("hola", 3), "holaholahola");
        assertEquals(StringUtil.repeat("hola", 1), "hola");

//        if (!result.equals("holahoAlahola")) {
//            throw new RuntimeException("ERROR");
//        }
//        if (result.equals("holaholahola")) {
//            System.out.println("Ok");
//        }

//        String result2 = StringUtil.repeat("hola", 1);
//
//        assertEquals(result2, "hola");
//        if (!result2.equals("hola")) {
//            throw new RuntimeException("ERROR");
//        }

//        if (result2.equals("hola")) {
//            System.out.println("Ok");
//        }

    }

    private static void assertEquals(String actual, String expected) {
        if (!actual.equals(expected)) {
            throw new RuntimeException(actual + "is not equal to expected: " + expected);
        }
    }

}