from car import Car
from account import Account

from uberX import UberX

if __name__ == "__main__":
    print("Hola")
    # car = Car()
    # car.licence = "QWQE"
    # car.driver = "Joel"
    # print(vars(car))
    
    # car2 = Car()
    # car2.licence = "XLSDJMM"
    # car2.driver = "Otro"
    # print(vars(car2))
    
    # car = Car("asas", Account("Joel", "XXAS"))
    # print(vars(car))
    # print(vars(car.driver))
    
    uberX = UberX("xxcc", Account("Joel", "XXAS"), "Otro", "Marca")
    print(vars(uberX))
    print(vars(uberX.driver))