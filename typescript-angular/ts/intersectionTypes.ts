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
/*En Typescript una intersección habla sobre la combinación de los tipos por lo que
  el resultante tiene todas las propiedades de los mismos.
  Una unión de tipos es un caso de uno u otro.
 */
type InterfacerMix = Interface1 & Interface2 & Interface3

const interfacerMix: InterfacerMix = {
  prop1:2,
  prop2: 5,
  prop3:"Hello"
}