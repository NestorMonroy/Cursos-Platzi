interface Interface1 {
    prop1: number;
}

interface Interface2 {
    prop2: number;
    prop3: string
}


type InterfacerMix = Interface1 & Interface2

const interfacerMix: InterfacerMix = {
    prop1:2,
    prop2: 5,
    prop3:"Hello"
}