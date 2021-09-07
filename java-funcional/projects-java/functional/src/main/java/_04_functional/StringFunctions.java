package _04_functional;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class StringFunctions {
    public static void main(String[] args) {
//        UnaryOperator:
//        Function, donde la entrada y la salida son del mismo tipo.
        UnaryOperator<String> quote = text -> "\"" + text + "\"";
        UnaryOperator<String> addMark = text -> text + "!";

        System.out.println(quote.apply("Hola nestor"));
        System.out.println(addMark.apply("Hola"));

//        BinaryOperator:
//        BiFunction donde los parámetros y la salida son del mismo tipo.
        //BiFunction<Integer, Integer, Integer> multiplicacion = (x,y) -> x*y;
        BinaryOperator<Integer> multiplicacion = (x, y) -> x * y;
        System.out.println(multiplicacion.apply(5, 1));

        BiFunction<String, Integer, String> leftPad =
                (text, number) -> String.format("%" + number + "s", text);

        System.out.println(leftPad.apply("Nestor", 5));


    }
}
