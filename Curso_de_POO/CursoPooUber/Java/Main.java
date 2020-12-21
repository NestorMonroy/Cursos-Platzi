class Main {
  public static void main(String[] args) {
    System.out.println("Hola");
    UberX uberX = new UberX("ASASQ331", new Account("Joel", "ASAS"), "XXMarca", "UUModelo");
    uberX.setPassenger(4);
    // System.out.println("Car Licence: " + car.licence );
    uberX.printDataCar();

    // UberVan uberVan = new UberVan("ASASQ331", new Account("Joel", "ASAS"));

    // uberVan.setPassenger(6);
    // uberVan.printDataCar();
    // Car car2 = new Car("XASSQ331", new Account("OTRO", "AAASAS"));;
    // car2.passenger = 2;
    // car2.printDataCar();
    // System.out.println("Car Licence: " + car2.licence );

  }
}