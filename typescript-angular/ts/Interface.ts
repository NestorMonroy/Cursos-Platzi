//interface Es un tipo abstracto, detona el contrato, representado una estructura para nuestro objecto

type Dni = number;

interface Persona {
    altura?: number;
    edad: number;
    nombre: string;
    apellido: string;
    dni?: Dni;
}

//Con ? puedes decir que el parametro es opcional
//Las clases igual pueden ser un TIPO
const persona: Persona = {
    //altura: 1.69,
    edad: 27,
    nombre: "Nestor ",
    apellido: "Monroy",
    //dni: 454547
}

