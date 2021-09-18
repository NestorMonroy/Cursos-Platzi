type SumaParameter = string | number; //Se puede utilizar interfaces
type SumaReturnType = number | string;


function suma(num1: SumaParameter, num2: SumaParameter): SumaReturnType {
    //Cuando se transforma el primer valor y se asignada al 2do en este caso los dos son Strings
    return String(num1) + num2 //Se transforma el 2do a String 
};


interface Interface1 {
    prop1: number;
}

interface Interface2 {
    prop2: number;
}

//Las interfaces se utilizan para los objectos
type InterfaceMix = Interface1 | Interface2

const interfaceMix: InterfaceMix = {
    prop1: 2,
    prop2: 9
    // prop3: 5 error porque no existe en ninguna de las interfaces
}