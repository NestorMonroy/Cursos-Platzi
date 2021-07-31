public class Doctor {

    static int globalID = 0; // Autoincrement
    String name;
    String email;
    String speciality;

    Doctor(String name, String speciality){
        System.out.println("Construyendo el objecto doctor");
        System.out.println("El nombre del Doctor asignado es: "+ name);
        globalID++;
        this.name = name;
        this.speciality = speciality;
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
