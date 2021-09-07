package _13_streams;

import _06_reference_operator.NombresUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Streams {
    public static void main(String[] args) {
        List<String> courseList = NombresUtils.getList("Java!", "FrontEnd", "BackEnd", "FullStack");
        //Operaciones con los datos (Forma comun para trabajar con una lista o arreglo)
        for (String course : courseList) {
            String newCourseName = course.toLowerCase().replace("!", "!!");
            System.out.println("Cursos: " + newCourseName);
        }

        // Con Stream.of es la forma mas sencilla de construir un Stream
        Stream<String> courseStream = Stream.of("Java!", "FrontEnd", "BackEnd", "FullStack");
//
//        Stream<Integer> lengthCourseStream = courseStream.map(course -> course.length());
//        Optional<Integer> longest = lengthCourseStream.max((x, y) -> y - x);

        // Cuando se genera un Stream este solo puede ser consumido una vez
        Stream<String> emphasisCourse = courseStream.map(course -> course + "!");
        Stream<String> justJavaCourses = emphasisCourse.filter(course -> course.contains("Java"));
        justJavaCourses.forEach(System.out::println);

        //Toda clase que implemente la interfaz collection, puede generar un Stream de sus elementos para poder agregar operaciones dentro de
        Stream<String> coursesStream2 = courseList.stream();

        //Stream no es necesario guardar en una variable cada operacion,
        // permite realizar todo el conjunto de operaciones que necesitemos e ir leyendo solamente los elementos que tengamos que hacer
        //Los Stream tienen dos tipos de operaciones, intermedias: genera un nuevo stream y
        // terminales: genera un dato final (en este caso regresa void)

//        coursesStream2.map(course -> course + "!!")
//                .filter(course -> course.contains("Java"))
//                .forEach(System.out::println);

        addOperator(coursesStream2.map(course -> course + "!!")
                .filter(course -> course.contains("Java")))
                .forEach(System.out::println);
    }

    //Funciones que devuleve un Stream , ya que agrega operadores al stream que reciben como parametro HOF
    static <T> Stream<T> addOperator(Stream<T> stream) {
        // con .peek(), toma un consumer, pero no modifica los datos permite generar una iteracion de datos, no modifica el Stream
        // con .peek() recibe y devuelve el mismo tipo de dato
        return stream.peek(data -> System.out.println("Dato: " + data));
    }

}
