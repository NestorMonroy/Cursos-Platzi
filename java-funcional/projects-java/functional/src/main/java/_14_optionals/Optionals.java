package _14_optionals;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
        List<String> names = getNames();
        //Por cada ejecución de null, tenemos que revisar si esta presente o no
        if (names != null) {
            //Operar con nombres.
        }

        //Operar con el Optional
        Optional<List<String>> optionalNames = getOptionalNames();
        if (optionalNames.isPresent()) {

        }
        // Se hace funcional ifPresent() utiliza un consumer, funcion que toma un dato y no regresa ningun resultado,
        // se utiliza una lambda y un metodo de referencia (::)
        optionalNames.ifPresent(namesValue -> namesValue.forEach(System.out::println));

        /*Si el optional devuelve una lista podemos generar un iterador apartir de los elementos
        de la lista con optionalNames.flatMap(), consume una funcion y un optional.

         Para la conversion de datos se utiliza optionalNames.map(), cambia tipo de dato

        * */

        Optional<String> valuablePlayer = optionalValuablePlayer();
        String valuablePlayerName=  valuablePlayer.orElseGet(() -> "No player");
    }
    //Método que devuelve una lista de algo
    static List<String> getNames() {
        List<String> list = new LinkedList<>();
        //Cuando no tienes elementos, se usa Collections.emptyList();
        return Collections.emptyList();
    }

    static String mostValuablePlayer() {
        //return **
        return null;
    }

    static int mostExpensiveItem() {
        return -1;
    }

    //Funciones con Optional
    static Optional<List<String>> getOptionalNames() {
        List<String> nameList = new LinkedList<>();
        //Obtención de nombres
        return Optional.of(nameList);
    }

    //Devolver un dato cuando no este presente
    static Optional<String> optionalValuablePlayer() {
        //Optional.ofNullable(): Desconocemos el valor de una variable
        //return Optional.ofNullable();
        try {
            return Optional.of("Nestor");
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Optional.empty(): Cuando no encontremos casos
        return Optional.empty();
    }
}
