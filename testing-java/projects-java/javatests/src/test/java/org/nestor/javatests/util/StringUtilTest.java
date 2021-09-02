package org.nestor.javatests.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void testRepeat() {
        //System.out.println(result);

        Assert.assertEquals("holaholahola", StringUtil.repeat("hola", 2));
        Assert.assertEquals("hola", StringUtil.repeat("hola", 1));

        //Assert.assertEquals(StringUtil.repeat("hola", 1), "hola");
        //assertEquals(StringUtil.repeat("hola", 1), "hola");

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

//    private static void assertEquals(String actual, String expected) {
//        if (!actual.equals(expected)) {
//            throw new RuntimeException(actual + "is not equal to expected: " + expected);
//        }
//    }

}