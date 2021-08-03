package Collections.List.ExampleArrayList;

import java.util.Objects;

public class Empleado {

    public Empleado(int id, String nombre, int edad, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return this.nombre;
    }
    public int getId(){
        return this.id;
    }


    public String dameDatos() {
        return "El empleado se llama " + nombre + ". Tiene " + edad +
                " años y un salario de " + salario;
    }

    private int id;
    private String nombre;
    private int edad;
    private double salario;


    // Se generan equals y hashCode ya que ayudara a comparar los objectos de toda la lista
    // asociar el valor asignado es igual // se genera valor referencia
    // con esto se ingresan valores unicos en ExampleHashSet

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return id == empleado.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }



//    /*
//     * Step 2. Define the compareTo method.
//     * This compareTo method will sort Emp objects
//     * in ascending order according the id
//     */
//    public int compareTo(Empleado otherEmp) {
//        return getId() - otherEmp.getId();
//    }

//    public int compareTo(Empleado obj) {
//        // we sort objects on the basis of Student Name using compareTo of String Class
//        return this.nombre.compareTo(obj.nombre);
//    }


}
