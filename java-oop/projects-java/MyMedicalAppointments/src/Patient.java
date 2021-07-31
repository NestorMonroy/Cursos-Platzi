public class Patient {
    int globalID;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String birthday;
    private String blood;
    private Double weight;
    private Double height;

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
