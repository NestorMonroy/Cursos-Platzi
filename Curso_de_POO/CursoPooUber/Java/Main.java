class Main {
  public static void main(String[] args) {
    System.out.println("Hola");
    Car car = new Car("ASASQ331", new Account("Joel", "ASAS"));
    car.passeger = 4;
    //System.out.println("Car Licence: " + car.licence );
    car.printDataCar();
    Car car2 = new Car("XASSQ331", new Account("OTRO", "AAASAS"));;

    car2.passeger = 2;
    car2.printDataCar();
    //System.out.println("Car Licence: " + car2.licence );
 
  }
}