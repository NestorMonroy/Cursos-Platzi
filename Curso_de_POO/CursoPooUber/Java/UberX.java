class UberX extends Car {
  String brand;
  String model;

  public UberX(String licence, Account driver, String brand, String model ) {
    super(licence, driver);
    this.brand = brand;
    this.model = model;

  }
  
  @Override
  void printDataCar() {
    super.printDataCar();
    System.out.println("Modelo: " + model + "Marca: " + brand );
  }

}
