public class Doctor {
    int id;
    String name;
    String speciality;

    Doctor(){
        System.out.println("Construyendo el objecto doctor");
    }

    Doctor(String name){
        System.out.println("El nombre del Doctor asignado es: " + name);
    }

    //Comportamientos
    public void showName(){
        System.out.println(name);
    }
}
