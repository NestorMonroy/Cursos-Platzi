package org.nestor.javatests.roman_numerals;

public class RomanNumerals {

    static int n;
    static String roman;

    public static String arabicToRoman(int num) {
        n = num;
        roman = "";

        nIsGreaterThan(1000, "M");

        nIsGreaterThan(900, "CM");

        nIsGreaterThan(500, "D");

        nIsGreaterThan(400, "CD");

        asLongAsNIsGreaterThan(100, "C");

        nIsGreaterThan(90, "XC");

        nIsGreaterThan(50, "L");

        nIsGreaterThan(40, "XL");

        asLongAsNIsGreaterThan(10, "X");

        nIsGreaterThan(9, "IX");

        nIsGreaterThan(5, "V");

        nIsGreaterThan(4, "IV");

        asLongAsNIsGreaterThan(1, "I");
        return roman;
    }

    private static void asLongAsNIsGreaterThan(int num, String rom) {
        for (int i = num; i <= n; n -= num) {
            roman += rom;
        }
    }

    private static void nIsGreaterThan(int num, String rom) {
        if (n >= num) {
            roman += rom;
            n -= num;
        }
    }
}

//public class RomanNumerals {
//    public enum RomanNumber {
//        I, V, X, L, C, D, M
//    }
//
//    public static int toNumericValue(RomanNumber number) {
//        int value = 0;
//
//        if (number == RomanNumber.I) {
//            value = 1;
//        } else if (number == RomanNumber.V) {
//            value = 5;
//        } else if (number == RomanNumber.X) {
//            value = 10;
//        } else if (number == RomanNumber.L) {
//            value = 50;
//        } else if (number == RomanNumber.C) {
//            value = 100;
//        } else if (number == RomanNumber.D) {
//            value = 500;
//        } else if (number == RomanNumber.M) {
//            value = 1000;
//        }
//
//        return value;
//    }
//
//
//    public static String arabicToRoman(int number) {
//        StringBuilder sb = new StringBuilder();
//
//        while (number != 0 && number > -1 && number < 4000) {
//
//            int nextNumber = findNextNumber(number);
//
//            if (number == 4) {
//                sb.append("IV");
//            } else if (number == 9) {
//                sb.append("IX");
//            } else if (number == 40) {
//                sb.append("XL");
//            } else if (number == 90) {
//                sb.append("XC");
//            } else if (number == 400) {
//                sb.append("CD");
//            } else if (number == 900) {
//                sb.append("CM");
//            } else if (number - toNumericValue(RomanNumber.M) == nextNumber) {
//                sb.append(RomanNumber.M);
//            } else if (number - toNumericValue(RomanNumber.D) == nextNumber) {
//                sb.append(RomanNumber.D);
//            } else if (number - toNumericValue(RomanNumber.C) == nextNumber) {
//                sb.append(RomanNumber.C);
//            } else if (number - toNumericValue(RomanNumber.L) == nextNumber) {
//                sb.append(RomanNumber.L);
//            } else if (number - toNumericValue(RomanNumber.X) == nextNumber) {
//                sb.append(RomanNumber.X);
//            } else if (number - toNumericValue(RomanNumber.V) == nextNumber) {
//                sb.append(RomanNumber.V);
//            } else if (number - toNumericValue(RomanNumber.I) == nextNumber) {
//                sb.append(RomanNumber.I);
//            }
//
//            number = nextNumber;
//        }
//
//
//        return replaceRepeatingLetters(sb);
//    }
//
//    private static String replaceRepeatingLetters(StringBuilder sb) {
//
//        String str = sb.toString();
//        str = str.replace("IIII", "IV");
//        str = str.replace("VIV", "IX");
//        str = str.replace("XXXX", "XL");
//        str = str.replace("LXL", "XC");
//        str = str.replace("CCCC", "CD");
//        str = str.replace("DCD", "CM");
//
//        return str;
//    }
//
//    private static int findNextNumber(int number) {
//
//        if (number == 900) {
//            number -= 900;
//        } else if (number == 400) {
//            number -= 400;
//        } else if (number == 90) {
//            number -= 90;
//        } else if (number == 40) {
//            number -= 40;
//        } else if (number == 4) {
//            number -= 4;
//        } else if (number == 9) {
//            number -= 9;
//        } else if (number >= 1000) {
//            number -= toNumericValue(RomanNumber.M);
//        } else if (number >= 500) {
//            number -= toNumericValue(RomanNumber.D);
//        } else if (number >= 100) {
//            number -= toNumericValue(RomanNumber.C);
//        } else if (number >= 50) {
//            number -= toNumericValue(RomanNumber.L);
//        } else if (number >= 10) {
//            number -= toNumericValue(RomanNumber.X);
//        } else if (number >= 5) {
//            number -= toNumericValue(RomanNumber.V);
//        } else {
//            number -= toNumericValue(RomanNumber.I);
//        }
//
//        return number;
//    }
//}


//
//public class RomanNumerals {
//
//    public static String arabicToRoman(int number) {
//        InfoNumeral infoNumeral;
//        infoNumeral = new InfoNumeral(number,"");
//        infoNumeral = multiple10(infoNumeral, 1000, "M");
//        infoNumeral = replaceValue(infoNumeral, 900, "CM");
//        infoNumeral = replaceValue(infoNumeral, 500, "D");
//        infoNumeral = replaceValue(infoNumeral, 400, "CD");
//        infoNumeral = multiple10(infoNumeral, 100, "C");
//        infoNumeral = replaceValue(infoNumeral, 90, "XC");
//        infoNumeral = replaceValue(infoNumeral, 50, "L");
//        infoNumeral = replaceValue(infoNumeral, 40, "XL");
//        infoNumeral = multiple10(infoNumeral, 10, "X");
//        infoNumeral = replaceValue(infoNumeral, 9, "IX");
//        infoNumeral = replaceValue(infoNumeral, 5, "V");
//        infoNumeral = replaceValue(infoNumeral, 4, "IV");
//        infoNumeral = multiple10(infoNumeral, 1, "I");
//        return infoNumeral.getInfo();
//    }
//
//    private static InfoNumeral replaceValue(InfoNumeral infoNumeral, int number, String value){
//        if(infoNumeral.getNumber() >= number)
//            return new InfoNumeral(infoNumeral.getNumber() - number, infoNumeral.getInfo() + value);
//        else
//            return infoNumeral;
//    }
//
//    private static InfoNumeral multiple10(InfoNumeral infoNumeral, int multiple, String value) {
//        String result = infoNumeral.getInfo();
//        int aux = infoNumeral.getNumber();
//        if (aux < multiple)
//            return infoNumeral;
//
//        while( aux >= multiple) {
//            result += value;
//            aux -= multiple;
//        }
//        return new InfoNumeral(aux, result);
//    }
//
//
//}
