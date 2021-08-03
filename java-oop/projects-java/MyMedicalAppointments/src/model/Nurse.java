package model;

public class Nurse extends User {

    private String speciality;

    Nurse(String name, String email){
        super(name, email);

    }

    @Override
    public void showDataUser() {
        System.out.println("Hospital: CruzVerde");
        System.out.println("Hospital: otro");
        System.out.println("Hospital: CruzVerde");


    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }
}
