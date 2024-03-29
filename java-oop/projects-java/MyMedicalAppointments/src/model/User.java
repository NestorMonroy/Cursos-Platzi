package model;

public abstract class User {
    int globalID;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private String birthday;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public int getGlobalID() {
        return globalID;
    }

    public void setGlobalID(int globalID) {
        this.globalID = globalID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() != 8){
            System.out.println("El numero telefonico debe de ser de 8 digitos");
        } else if(phoneNumber.length() == 8){
            this.phoneNumber = phoneNumber;
        }
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public  String toString(){
        return "User "+ name + ", Email: "+ email + ", Address: " + address+ ". Phone: "+ phoneNumber;
//
    }
    //Defenimos el metodo
    public abstract void showDataUser();
}
