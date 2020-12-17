class Car {
  Integer id;
  String licence;
  Account driver;
  Integer passeger;

  public Car(String licence, Account driver) {
    // this el objecto
    this.licence = licence;
    this.driver = driver;

  }

  void printDataCar() {
    System.out.println("Car licence " + licence + "Name Driver " + driver.name);
  }
}
