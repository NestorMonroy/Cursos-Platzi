package Collections.ExampleArrayList;

import java.util.Objects;

public class Empleado {

    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String dameDatos() {
        return "El empleado se llama " + nombre + ". Tiene " + edad +
                " años y un salario de " + salario;
    }

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
        return nombre.equals(empleado.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
