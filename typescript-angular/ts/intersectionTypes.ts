interface Interface1 {
    prop1: number;
}

interface Interface2 {
    prop2: number;
    prop3: string
}

interface Interface3 {
    prop2: number; //No importa que se repitan las propiedades
}

type InterfacerMix = Interface1 & Interface2 & Interface3

const interfacerMix: InterfacerMix = {
    prop1:2,
    prop2: 5,
    prop3:"Hello"
}