package ui;

import model.Doctor;

import java.util.ArrayList;
import java.util.Scanner;

public class UIDoctorMenu {

    //Array para extraer las citas
    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<>();

    public static void showDoctorMenu(){
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Hello Doctor");
            System.out.println("Welcome " + UIMenu.doctorLogged.getName());
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Scheduled appointsments");
            System.out.println("0. Logout");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            switch (response){
                case 1:
                    showAddAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 3:
                    UIMenu.showMenu();
            }
        }while (response != 0);
    }

    private static void showAddAvailableAppointmentsMenu(){
        int response = 0;
        do{
            System.out.println("\n\n");
            System.out.println("::Add Available Appointmet");
            System.out.println(":: Select a months");
            for (int i = 0; i < 3; i++) {
                int j = i+1;
                System.out.println(j+". "+UIMenu.MONTHS[i]);
            }
            System.out.println("0 Return.");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());
            if (response > 0 && response < 4){
                //1,2,3
                int montSelected = response;
                System.out.println(montSelected + " . " + UIMenu.MONTHS[montSelected-1]);
                System.out.println("Insert the date available: [dd-mm-yyyy]");
                String date = sc.nextLine();

                System.out.println("Your date is: " + date + "\n1.Correct  \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());
                if (responseDate == 2) continue; // No se sale del ciclo, vuelve inciar donde se quedo
                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date: " + date + " [16:00] ");
                    time = sc.nextLine();
                    System.out.println("Your time is: " + time + "\n1.Correct  \n2. Change Time");
                    responseTime = Integer.valueOf(sc.nextLine());

                }while (responseTime == 2);

                UIMenu.doctorLogged.addAvailableAppointment(date, time);

                checkDoctorAvailableApoitment(UIMenu.doctorLogged);
            }else if (response == 0){
                showDoctorMenu();
            }
        }while (response !=0);
    }


    //Se genera un nuevo metodo para modularizar

    private static void checkDoctorAvailableApoitment(Doctor doctor){
        //sea diferente de 0 y no se encuentre dentro de
        if(doctor.getAvailableAppointments().size() > 0 && doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }
}
