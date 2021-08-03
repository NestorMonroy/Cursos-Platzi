package Collections.Set;

import Collections.List.ExampleArrayList.Empleado;

import java.util.HashSet;
import java.util.Set;

public class ExampleHashSet {
    public static void main(String[] args) {
        Set<Empleado> lista = new HashSet<>();

        //Set<String> lista = new HashSet();
        // Cuando se genera una instancia de objetos, se genera bloques de memoria distintos
        // todos estos objectos tienen una instancia nueva

        lista.add(new Empleado(1, "Luis",22,15.35));
        lista.add(new Empleado(2,"Luis",22,15.35));
        lista.add(new Empleado(3, "Carlos",22,15.35));
        lista.add(new Empleado(4,"Luis",22,15.35));

        //No guarda con el order, se preocupa que no tenga valores duplicados
        for (Empleado elemento:lista) {
            System.out.println(elemento.getNombre());
        }

    }
}
