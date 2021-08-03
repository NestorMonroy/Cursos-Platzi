package Collections.List;

import java.util.LinkedList;
import java.util.ListIterator;

public class ExampleLinkedList {
    public static void main(String[] args) {
        //Agregar elementos es mas eficiente LinkedList
        LinkedList<String> personas = new LinkedList<String>();
        personas.add("Luis0");
        personas.add("Luis1");
        personas.add("Luis2");
        personas.add("Luis3");
        personas.add("Luis4");

        System.out.println(personas.size());
        //Cambiar la posicion del iterador con ListIterator
        ListIterator<String> it = personas.listIterator();
        it.next();
        it.add("Luis5");

        for (String persona: personas) {
            System.out.println(persona);
        }
    }

}
