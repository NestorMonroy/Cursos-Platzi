package _11_composition;

import java.util.function.Function;

public class MatOperations2 {
    public static void main(String[] args) {
        Function<Integer, Integer> multipleBy3
                = x -> {
            System.out.println("Multiplicando x: "+ x + " por 3.");
            return x * 3;
        };

        Function<Integer, Integer> add1MultipleBy3
                /*Se genera una funcion intermedia a travez de compose,
                compose, toma una funcion, ejecuta primero esa funcion, y
                posterior ejecuta la funcion que se  mando a llamar.
                **Funcion compuesta basada en dos funciones **
                * */
                = multipleBy3.compose(y -> {
            System.out.println("Le agregare 1 a: " + y);
            return y + 1;
        });

        Function<Integer, Integer> andSquare =
                /* Se toma una funcion y una vez ejecutado eso con .andThen
                 ejecuta una nueva funcion
                */
                add1MultipleBy3.andThen(x -> {
                    System.out.println("Estoy elevando " + x + " al cuadrado");
                    return x * x;
                });
        System.out.println(
                add1MultipleBy3.apply(5)
        );

        System.out.println(
                andSquare.apply(3)
        );
    }

}
