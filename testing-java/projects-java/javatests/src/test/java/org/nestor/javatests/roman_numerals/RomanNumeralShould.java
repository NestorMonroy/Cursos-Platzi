package org.nestor.javatests.roman_numerals;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class RomanNumeralShould {
    /*
    arabicToRoman(1) ⇒ "I"
    arabicToRoman(2) ⇒ "II"
    arabicToRoman(3) ⇒ "III"
    arabicToRoman(5) ⇒ "V"
    arabicToRoman(6) ⇒ "VI"
    arabicToRoman(7) ⇒ "VII"
    arabicToRoman(10) ⇒ "X"
    arabicToRoman(15) ⇒ "XV"
    arabicToRoman(11) ⇒ "XI"
    arabicToRoman(16) ⇒ "XVI"
    arabicToRoman(50) ⇒ "L"
    arabicToRoman(51) ⇒ "LI"
    arabicToRoman(55) ⇒ "LV"
    arabicToRoman(56) ⇒ "LVI"
    arabicToRoman(60) ⇒ "LX"
    arabicToRoman(70) ⇒ "LXX"
    arabicToRoman(80) ⇒ "LXXX"
    arabicToRoman(81) ⇒ "LXXXI"
    arabicToRoman(85) ⇒ "LXXXV"
    arabicToRoman(86) ⇒ "LXXXVI"
    arabicToRoman(126) ⇒ "CXXVI"
    arabicToRoman(2507) ⇒ "MMDVII"
    arabicToRoman(4) ⇒ "IV"
    arabicToRoman(9) ⇒ "IX"
    arabicToRoman(14) ⇒ "XIV"
    arabicToRoman(19) ⇒ "XIX"
    arabicToRoman(24) ⇒ "XXIV"
    arabicToRoman(40) ⇒ "XL"
    arabicToRoman(49) ⇒ "XLIX"
    arabicToRoman(90) ⇒ "XC"
    arabicToRoman(99) ⇒ "XCIX"
    arabicToRoman(400) ⇒ "CD"
    arabicToRoman(900) ⇒ "CM"

    Ten en cuenta que:
        El símbolo I puede restar a V y X.
        El símbolo X puede restar a L y C.
        El símbolo C puede restar a D y M.

    Las combinaciones en las que hay una resta son las siguientes: IV IX XL XC CD CM.
*/
    @Test
    public void convert_1_arabic_to_roman_I() {
        assertThat(RomanNumerals.arabicToRoman(1), is("I"));
    }

    @Test
    public void convert_2_arabic_to_roman_II() {
        assertThat(RomanNumerals.arabicToRoman(2), is("II"));
    }

    @Test
    public void convert_3_arabic_to_roman_III() {
        assertThat(RomanNumerals.arabicToRoman(3), is("III"));
    }

    @Test
    public void convert_6_arabic_to_roman_VI() {
        assertThat(RomanNumerals.arabicToRoman(6), is("VI"));
    }
    @Test
    public void convert_7_arabic_to_roman_VII() {
        assertThat(RomanNumerals.arabicToRoman(7), is("VII"));
    }
    @Test
    public void convert_10_arabic_to_roman_X() {
        assertThat(RomanNumerals.arabicToRoman(10), is("X"));
    }
    @Test
    public void convert_11_arabic_to_roman_XI() {
        assertThat(RomanNumerals.arabicToRoman(11), is("XI"));
    }
    @Test
    public void convert_15_arabic_to_roman_XV() {
        assertThat(RomanNumerals.arabicToRoman(15), is("XV"));
    }
    @Test
    public void convert_16_arabic_to_roman_XVI() {
        assertThat(RomanNumerals.arabicToRoman(16), is("XVI"));
    }
    @Test
    public void convert_50_arabic_to_roman_L() {
        assertThat(RomanNumerals.arabicToRoman(50), is("L"));
    }


}