
import model.Doctor;
import model.Patient;
import model.User;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //showMenu();
        Doctor myDoctor = new Doctor("Nestor Monroy", "nestor@abc.com");
        myDoctor.addAvailableAppointment(new Date(), "4pm");
        myDoctor.addAvailableAppointment(new Date(), "10am");
        myDoctor.addAvailableAppointment(new Date(), "1pm");

        //System.out.println(myDoctor.getAvailableAppointments()); // Regresa el objecto
        System.out.println(myDoctor); // Regresa el objecto

//        for (Doctor.AvailableAppointment aA:myDoctor.getAvailableAppointments()) {
//            System.out.println(aA.getDate() + " " + aA.getTime());
//        }
        System.out.println();
        System.out.println();
        Patient patien = new Patient("Joel", "joel@abc.com");
        System.out.println(patien);
//        System.out.println(patien.getName());
//
//        //patien.
//
//        System.out.println();
//        System.out.println();

//
//        System.out.println(Doctor.Day.MONDAY.getSpanish());

//        int i = 0;
//        int b = 2;
//        b= i;

//        System.out.println();
//        System.out.println();
//
//        Patient patien = new Patient("Joel", "joel@abc.com");
//        patien.setWeight(50.6);
//        System.out.println(patien.getWeight());
//
//        patien.setPhoneNumber("1");
//        System.out.println(patien.getPhoneNumber());

        //Patient patien2 = new Patient("Berna", "berna@abc.com");

//        System.out.println(patien.name);
//        System.out.println(patien.email);
//
//        patien.height = 60.5; // kg
//        patien.weight = 1.61; // Mts.
//
//        System.out.println(patien.height);
//        System.out.println(patien.weight);
//
//        //Inconsistencia de datos
//        patien.weight = 54.5;
//        patien.name = "Juan";




//        System.out.println(patien);
//        System.out.println(patien2);
//        System.out.println();
//        System.out.println();
//        System.out.println(patien.getName());
//        System.out.println(patien2.getName());
//
//        patien2 = patien;
//        System.out.println();
//        System.out.println();
//        System.out.println(patien.getName());
//        System.out.println(patien2.getName());
//        System.out.println();
//        System.out.println();
//        patien2.setName("Nuevo 1");
//        System.out.println(patien.getName());
//        System.out.println(patien2.getName());

        User user = new Doctor("Nestor", "abc.com");
        System.out.println(user);
    }

}
