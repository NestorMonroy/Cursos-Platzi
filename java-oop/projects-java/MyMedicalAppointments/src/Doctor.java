public class Doctor {

    static int globalID = 0; // Autoincrement
    String name;
    String speciality;

    Doctor(){
        System.out.println("Construyendo el objecto doctor");
        globalID++;
    }

    Doctor(String name){
        System.out.println("El nombre del Doctor asignado es: " + name);
    }

    //Comportamientos
    public void showName(){
        System.out.println(name);
    }

    public void showId(){
        System.out.println("ID doctor: "+ globalID);
    }
}
