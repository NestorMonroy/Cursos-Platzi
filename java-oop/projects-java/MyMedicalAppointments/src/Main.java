public class Main {
    public static void main(String[] args) {
                           // Metodo Constructor
        Doctor myDoctor = new Doctor("Ejemplo 1");
        myDoctor.name = "Nestor Monroy";
        myDoctor.showName();
        Doctor d1 = new Doctor();
        Doctor d2 = new Doctor();
        Doctor d3 = new Doctor();
        System.out.println(d1.getId() + "," + d2.getId() + "," + d3.getId() );



    }
}
