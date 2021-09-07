package _07_inference;

import _06_reference_operator.NombresUtils;

import java.util.List;
import java.util.function.Function;

public class Inference {
    public static void main(String[] args) {
        Function<Integer, String> funcionConvertidora =
                integer -> "Al doble " + (integer * 2);
        //La inferencia de tipo, es cuando java se encarga de validar que los datos que estan pasando
        //atravez de la funcion, sea del tipo que corresponde. "Infiere" el tipo de dato
        List<String> alumnos = NombresUtils.getList("Paco", "Luis", "Nestor");
        alumnos.forEach((String name) -> System.out.println(name));
        alumnos.forEach(name -> System.out.println(name));
        alumnos.forEach(System.out::println);

    }
}
