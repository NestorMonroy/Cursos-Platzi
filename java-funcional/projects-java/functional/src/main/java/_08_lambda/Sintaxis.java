package _08_lambda;

import _06_reference_operator.NombresUtils;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Sintaxis {
    public static void main(String[] args) {
        List<String> cursos = NombresUtils.getList("Java", "Functional");
        cursos.forEach(curso -> System.out.println(curso));

        //Lamba definida por un tipo
        userZero(() -> 2);
        usarPredicado(text -> text.isEmpty());

        usarBifunction((x, y) -> x * y);

        usarBifunction((x, y) -> {
            System.out.println("X: " + x + "Y: " + y);
            return x - y;
        });
        //Es valido
        usarBifunction((Integer x, Integer y) -> x * y);

        //No recibe ni retorna ningun dato
        usarNada(() -> {
            System.out.println("Hola");
        });


    }

    static void userZero(ZeroArgumentos zeroArgumentos) {

    }

    // Predicate: Regresa un bolean
    static void usarPredicado(Predicate<String> predicado) {
    }

    static void usarBifunction(BiFunction<Integer, Integer, Integer> operacion) {
    }

    static void usarNada(OperarNada operarNada) {

    }

    @FunctionalInterface
    interface ZeroArgumentos {
        int get();
    }


    @FunctionalInterface
    interface OperarNada {
        void nada();
    }
}
