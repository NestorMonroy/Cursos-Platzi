type SumaParameter = string | number; //Se puede utilizar interfaces
type SumaReturnType = number | string;


function suma(num1: SumaParameter, num2: SumaParameter): SumaReturnType {
    return String(num1) + num2 //Se transforma el 2do a String 
};


interface Interface1 {
    prop1: number;
}

interface Interface2 {
    prop2: number;
}

type InterfaceMix = Interface1 | Interface2

const interfaceMix: InterfaceMix = {
    prop1: 2,
    prop2: 9
    // prop3: 5 error 
}