public class Doctor {
    int id;
    static int globalID = 0;
    String name;
    String speciality;

    Doctor(){
        System.out.println("Construyendo el objecto doctor");
        id=globalID;
        globalID++;
    }

    Doctor(String name){
        System.out.println("El nombre del Doctor asignado es: " + name);
    }

    //Comportamientos
    public void showName(){
        System.out.println(name);
    }

    public int getId(){
        return id;
    };
}
