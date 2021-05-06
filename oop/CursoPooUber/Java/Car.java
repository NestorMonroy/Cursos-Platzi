class Car {
  private Integer id;
  private String licence;
  private Account driver;
  private Integer passenger;

  public Car(String licence, Account driver) {
    // this el objecto
    this.licence = licence;
    this.driver = driver;

  }

  void printDataCar() {
    if(passenger != null) {
      System.out.println("Car licence " + licence + "Name Driver " + driver.name + " Passengers: " + passenger);
    }
  
  }

  public Integer getPassenger() {
    return passenger;
  }

  public void setPassenger(Integer passenger) {
    if (passenger == 4) {
      this.passenger = passenger;
    }else{
      System.out.println("Necesitas agregar 4 ");
    }

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLicence() {
    return licence;
  }

  public void setLicence(String licence) {
    this.licence = licence;
  }

  public Account getDriver() {
    return driver;
  }

  public void setDriver(Account driver) {
    this.driver = driver;
  }
  
}
