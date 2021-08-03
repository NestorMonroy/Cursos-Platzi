package model;
import java.util.ArrayList;
import java.util.Date;

public class Doctor extends User {

    public Doctor(String name, String email){
        super(name, email);
        System.out.println("Construyendo el objecto doctor");

        /*
        Se mueven a herencia
        System.out.println("El nombre del Doctor asignado es: "+ name);
        this.name = name;
        this.speciality = speciality;
         */
    }

    private String speciality;

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

//    @Override
//    public void schedule(Date date, String time) {
//
//    }

    public  enum Day{
        SUNDAY("Domingo", "Dimache"),
        MONDAY("Lunes", "Lundi"),
        TUESDAY("Martes", "Mardi"),
        WEDNESDAY("Miercoles", "Mercredi"),
        THURSDAY("Jueves", "Jeudi"),
        FRIDAY("Viernes", "Vendredi"),
        SATURDAY("Sabado", "Samedi");

        private String spanish;
        private String french;

        private Day(String s, String f){
            spanish = s;
            french = f;
        }

        public String getSpanish() {
            return spanish;
        }

        public String getFrench() {
            return french;
        }
    }


    /*
    Se mueven a herencia

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

     */

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

    @Override
    public String toString(){
        return super.toString() + "\nSpeciality:" +speciality + "\nAppointments: "+availableAppointments.toString();
    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Roja");
        System.out.println("Depatamento: Cancerologia");

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

        @Override
        public  String toString(){
         return "Available appointmets: \nDate: "+date+"\nTime: "+ time;
        }

        /*
        Se mueven a herencia
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
         */
    }
}
