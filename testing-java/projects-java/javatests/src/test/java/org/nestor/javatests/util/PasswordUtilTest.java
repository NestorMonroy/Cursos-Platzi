package org.nestor.javatests.util;

import org.junit.Test;


import static org.junit.Assert.*;
import static org.nestor.javatests.util.PasswordUtil.SecurityLevel.*;

public class PasswordUtilTest {

    @Test
    public void weak_when_has_less_than_8_letters() {
         assertEquals(WEAK, PasswordUtil.assessPassword("1234567"));
    }

    @Test
    public void weak_when_has_less_only_letters() {
         assertEquals(WEAK, PasswordUtil.assessPassword("abcdefghsddf"));
    }

    @Test
    public void medium_when_has_letters_and_numbers() {
         assertEquals(MEDIUM, PasswordUtil.assessPassword("123abcadff"));
    }

    @Test
    public void strong_when_has_letters_numbers_symbols() {
         assertEquals(STRONG, PasswordUtil.assessPassword("123abcad#f"));
    }
}