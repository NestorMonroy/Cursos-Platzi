package Collections.Set;

import Collections.List.ExampleArrayList.Empleado;

import java.util.Set;
import java.util.TreeSet;

public class ExampleTreeSet {
    public static void main(String[] args) {
        /*

        Set<String> lista = new TreeSet<>();
        //AGREGAR VALORES UNICOS Y TE ORDENA LOS VALORES
        lista.add("Nestor");
        lista.add("Nestor1");
        lista.add("Nestor2");
        lista.add("Nestor");
        lista.add("AAA");
        for (String elemento: lista){
            System.out.println(elemento);
        }

         */

        Set<Empleado> lista = new TreeSet<>();
        System.out.println(lista.add(new Empleado(1,"Nestor", 20, 153.6)));
        //lista.add(new Empleado("Nestor", 20, 153.6));
//        lista.add(new Empleado("Maria", 22, 15.98));
//        lista.add(new Empleado("Luis", 25, 15.8));
//        lista.add(new Empleado("Luis", 25, 15.8));
//        lista.add(new Empleado("AA", 35, 15.98));
//
//        for(Empleado empleado:lista ){
//            System.out.println(empleado);
//        }
    }
}
