package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu(){
        int response = 0 ;
        do {
            System.out.println("\n");
            System.out.println("Patient");
            System.out.println("Welcome: " + UIMenu.patientLogged);
            System.out.println("1. Book an appointment");
            System.out.println("2. My Appointments");
            System.out.println("3. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();
                    break;
                case 2:
                    showPatientMyApointsments();
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }

        }while (response!=0);
    }


    private static void showBookAppointmentMenu(){
        int response = 0;
        do {
            System.out.println(":: Book an appointment");
            System.out.println(":: Select date");
            //Mostrar las fechas de los doctores
            //Integer Numeracion de la lista de fechas, a modo de indice
            //Indice de la fecha que selecione el usuario
            //[doctors]
            //-1.- doctor 1
            //    //Array de citas disponibles -fecha1
            //    //Array de citas disponibles -fecha2
            //-2. doctor 2
            //Recorrer estructura de datos
            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();
            //System.out.println(UIDoctorMenu.doctorsAvailableAppointments.size());
            int k = 0;
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size() ; i++) {
                ArrayList<Doctor.AvailableAppointment> availableAppointments = UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();
                //TreeMap estructura de arbol
                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();
                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". "+ availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");
            for (Map.Entry<Integer, Doctor> doc :doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }
            System.out.println(doctorSelected.getName() +
                    ". Date: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                    ". Time: " +
                    doctorSelected.getAvailableAppointments().get(indexDate).getTime());

            System.out.println("Confirm your appointment:\n1. Yes \n2. Chage Date ");
            response = Integer.valueOf(sc.nextLine());
            if (response == 1) {
                //System.out.println(doctorSelected.getAvailableAppointments().get(indexDate).getDate(null));
                UIMenu.patientLogged.addAppointmentDoctors(
                        doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                showPatientMenu();
            }
        }while (response !=0 );
    }

    private static void showPatientMyApointsments(){
        int response = 0;
        do{
            System.out.println(":: My Apointments");
            if(UIMenu.patientLogged.getAppointmentDoctors().size() == 0){
                System.out.println("Dont have't appoitments");
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        "Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\n Doctor: " + "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor()
                );
            }
            System.out.println("0. Return");

        }while(response!=0);
    }
}
