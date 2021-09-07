package reference_operator;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class NombresUtils {
    public static void main(String[] args) {
        List<String> profesores = getList("Nestor", "Luis", "Joel");

        Consumer<String> printer = text -> System.out.println(text);
        profesores.forEach(printer);

        System.out.println("*****");
        //Poder referenciar un método, los métodos también son funciones, estan liagadas a una clase
        profesores.forEach(System.out::println);

    }
    static<T> List<T> getList(T... elements){
        return Arrays.asList(elements);
    }
}
