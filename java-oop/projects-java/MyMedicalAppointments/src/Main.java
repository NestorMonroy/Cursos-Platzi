import static ui.UIMenu.*;

public class Main {
    public static void main(String[] args) {
        //showMenu();
        Doctor myDoctor = new Doctor("Nestor Monroy", "Cardiología");
        System.out.println(myDoctor.name);
        System.out.println(myDoctor.speciality);

        int i = 0;
        int b = 2;
        b= i;

        System.out.println();
        System.out.println();

        Patient patien = new Patient("Joel", "joel@abc");
        Patient patien2 = new Patient("Berna", "berna@abc");

        System.out.println(patien);
        System.out.println(patien2);
        System.out.println();
        System.out.println();
        System.out.println(patien.getName());
        System.out.println(patien2.getName());

        patien2 = patien;
        System.out.println();
        System.out.println();
        System.out.println(patien.getName());
        System.out.println(patien2.getName());
        System.out.println();
        System.out.println();
        patien2.setName("Nuevo 1");
        System.out.println(patien.getName());
        System.out.println(patien2.getName());

    }

}
