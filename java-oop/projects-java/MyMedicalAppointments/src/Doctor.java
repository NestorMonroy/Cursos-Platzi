import java.util.ArrayList;
import java.util.Date;

public class Doctor {

    static int globalID = 0; // Autoincrement
    private String name;
    private String email;
    private String speciality;

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

    //Solo la clase de doctor puede generar citas
    //Metodo que agrega citas
    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();
    public void addAvailableAppointment(Date date, String time){
        //availableAppointments.add(new AvailableAppointment(date,time));
        availableAppointments.add(new Doctor.AvailableAppointment(date, time));
    };

    //Metodo que regresa la lista de citas
    public ArrayList<AvailableAppointment> getAvailableAppointments() {
        return availableAppointments;
    }

    public static class AvailableAppointment{
        private int id_availableAppointment;
        private Date date;
        private String time;


        public AvailableAppointment(Date date, String time){
            this.date = date;
            this.time = time;
        }

        public int getId_availableAppointment() {
            return id_availableAppointment;
        }

        public void setId_availableAppointment(int id_availableAppointment) {
            this.id_availableAppointment = id_availableAppointment;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
