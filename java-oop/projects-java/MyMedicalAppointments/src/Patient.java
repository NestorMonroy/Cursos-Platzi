public class Patient extends User {

    private String blood;
    private double weight;
    private double height;

    Patient(String name, String email){
        //super objecto padre
        super(name, email);
    }


    //54.5
    public void setWeight(double weight){
        this.weight = weight;
    }

    // 54.5 kg. String // Cuando se pone Tipo de dato, se deve utilizar retun
    public String getWeight() {
        return this.weight + "Mts.";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getHeight() {
        return height + "Kg.";
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    @Override
    public  String toString(){
        return super.toString() + "\n Age: " + getBirthday()+"\n Weigth: " + getWeight()+ "\n Height: " + getHeight() + "\n Blood: " + getBlood();
    }

    /*
    Se mueven a herencia
    public int getGlobalID() {
        return globalID;
    }

    public void setGlobalID(int globalID) {
        this.globalID = globalID;
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




    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

     */
}
