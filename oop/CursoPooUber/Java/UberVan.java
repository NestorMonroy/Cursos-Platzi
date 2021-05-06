import java.util.ArrayList;
import java.util.Map;

class UberVan extends Car {
  Map<String, Map<String, Integer>> typeCarAccepted;
  ArrayList<String> seatsMaterial;
  private Integer passenger;

  public UberVan(String licence, Account driver, Map<String, Map<String, Integer>> typeCarAccepted,
      ArrayList<String> seatsMaterial) {
    super(licence, driver);

    this.typeCarAccepted = typeCarAccepted;
    this.seatsMaterial = seatsMaterial;
  }

  public UberVan(String licence, Account driver) {
    super(licence, driver);

  }

  @Override
  public void setPassenger(Integer passenger) {
    if (passenger ==6) {
      this.passenger = passenger;
    } else {
      System.out.println("Necesitas agregar 6 ");
    }
  }

}
