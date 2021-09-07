package _04_functional;

import java.util.function.Function;
import java.util.function.Predicate;

public class MathFunctions {
    public static void main(String[] args) {
        Function<Integer, Integer> squareFunction = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
        System.out.println(squareFunction.apply(5));
        System.out.println(squareFunction.apply(25));
        System.out.println(square(5));

        //Definición de funcion mas simple, sin utilizar un operador @Override
        Function<Integer, Boolean> isOdd = x -> x % 2 == 1;

        //Predicate -> Trabaja sobre un tipo y regresa un bolean
        Predicate<Integer> isEven = x -> x % 2 == 0;
        isEven.test(4); //  con .test revisamos el resultado

        Predicate<Student> isApproved = student -> student.getCalificacion() >= 6.0;

        Student nestor = new Student(5);
        System.out.println(isApproved.test(nestor));


    }

    static class Student {
        private double calificacion;

        Student(double calificacion) {
            this.calificacion = calificacion;
        }

        public double getCalificacion() {
            return calificacion;
        }

    }

    static int square(int x) {
        return x * x;
    }

}
