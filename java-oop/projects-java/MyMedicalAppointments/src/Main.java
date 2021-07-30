import static ui.UIMenu.*;

public class Main {
    public static void main(String[] args) {
                           // Metodo Constructor
        Doctor myDoctor = new Doctor();
        myDoctor.name = "Nestor Monroy";
        myDoctor.showName();
        myDoctor.showId();
        System.out.println(Doctor.globalID);

        //Doctor.globalID++;

        Doctor myDoctorNess = new Doctor();
        myDoctor.showId();
        System.out.println(Doctor.globalID);

        showMenu();

    }

}
