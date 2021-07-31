public class Patient {
    String name;
    String email;
    String address;
    String phoneNumber;
    String birthday;
    String blood;
    Double weight;
    Double height;



    Patient(String name, String email){
        this.name = name;
        this.email = email;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}
