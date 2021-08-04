## Clases del Curso de TypeScript con Angular por Belatrix

### ¿Qué es Typescript?

TypeScript es un lenguaje fuertemente tipado creado por Microsoft, aunque está muy relacionado con el framework Angular, TypeScript es un lenguaje independiente que puedes usar para proyectos de back-end con Express o Front-end ya sea con Vue, React o Angular. Para que TypeScript pueda correr en el navegador debe ser transpilado a JavaScript con herramientas como Babel.

VS ESLint tslint plugins

<img src="./static/images/ts_001.jpg" with="20%"/>

----------------

### Types, Type Inference y Type keyword

A diferencia de JavaScript, TypeScript es un lenguaje fuertemente tipado. Mientras que en JavaScript declaramos una constante de la siguiente manera:

const a = 'hola'

En TypeScript utilizando el carácter ‘:’ le asignamos un tipo de dato a la variable :

const a: string = 'hola'

En caso de que no le asignemos un tipo de dato a la variable, TypeScript automáticamente le va a asignar un tipo de dato, esto es el Type Inference.

Si le asignamos el tipo de dato any a una variable, esta variable va a poder almacenar cualquier tipo de dato, similar a JavaScript Vainilla.

Dentro de TypeScript contamos con la palabra reservada type que nos va a ser de utilidad cuando hagamos nuestros propios tipos de datos.

```ts
let a: string = 'Hola';
a = 'Holas';
//a = 2; //Error

let b: number = 10;

//b='a'; //error

b = 20;
b = 10 + 10;

const num1 = 10;
const num2 = 10;
b = num1 + num2;


function suma(num1: number, num2:number): number{
    return num1 + num2
}

function sumaJavascriptVanilla(num1,num2){
    return num1 + num2
}

//No se sabe el tipo de valor
let anyValue: any = 10;
anyValue = '10';

//Crear un alias para facilitar el cambio en un futuro
type dni = string;
// let dniNumer: dni = 2155; //Error

```

### Clases

Dentro de TypeScript podemos realizar programación orientada a objetos y como su nombre lo dice vamos a programar objetos, pero para generar dichos objetos primero debemos crear su plantilla base que recibe el nombre de clase.

Una clase está integrada por propiedades y funciones, estas pueden ser privadas, públicas o protected.

A la variable que le asignamos el valor de un objeto debemos indicarle que su tipo de dato es igual a la clase.

Una característica de la programación orientada a objetos es que podemos crear clases padre que hereden sus propiedades y funciones a una clase hijo, esto es la herencia y dentro de TypeScript se representa con la palabra extends.

```ts
class Transporte {
    private velocidad: number;
    private formaDeMovilidad: string;

    constructor(velocidad: number, formaDeMovilidad: string) {
        this.velocidad = velocidad;
        this.formaDeMovilidad = formaDeMovilidad;
    }

    getVelocidad() {
        return this.velocidad
    }

    setVelocidad() {
        this.velocidad = this.velocidad
    }

    getFormaDeMovilidad() {
        return this.formaDeMovilidad
    }

    setFormaDeMovilidad() {
        this.formaDeMovilidad = this.formaDeMovilidad
    }

}

const transporte: Transporte = new Transporte(20, 'suelo');

//Herencia extenderla o redefinirlas
class Auto extends Transporte {
    private cantidadDePruertas: number;
    constructor(velocidad: number, formaDeMovilidad: string, cantidadDePuertas: number) {
        super(velocidad, formaDeMovilidad);
        this.cantidadDePruertas = cantidadDePuertas
    }

    getVelocidad() {
        return super.getVelocidad() + 10
        //return 'Mi velocidad es de un automovil y es de : ' + super.getVelocidad();
    }

    getcantidadDePruertas() {
        return this.cantidadDePruertas;
    }

    setcantidadDePruertas() {
        this.cantidadDePruertas = this.cantidadDePruertas;
    }

}


const auto:Auto = new Auto(20, 'suelo', 4);


```

### Interfaces

Una interfaz es un tipo abstracto que sirve como contrato para la estructura de un objeto y al igual que las clases puede ser utilizada como un tipo de dato. Para declarar una interfaz en TypeScript utilizamos la palabra clave interface.

Dentro de las interfaces en TypeScript podemos manejar propiedades opcionales añadiendo el signo de pregunta ‘?’ al final del nombre de la propiedad.


```ts
//Tipo abstracto, detona el contrato, representado una estructura para nuestro objecto

type Dni = number;

interface Persona {
    altura?: number;
    edad: number;
    nombre: string;
    apellido: string;
    dni?: Dni;
}

//Con ? puedes decir que el parametro es opcional

const persona: Persona = {
    //altura: 1.69,
    edad: 27,
    nombre: "Nestor ",
    apellido: "Monroy",
    //dni: 454547
}

```
### Shapes

Cada uno de los tipos tiene una forma o estructura en que es representado, esto es mediante sus propiedades. Dentro de TypeScript si dos variables poseen propiedades idénticas aunque sean de distintas interfaces o clases, estas pueden ser asignadas entre sí.

```ts
class Persona {
  private edad: number;
  private altura: number;
  private dni: string;

  //Para poder instancias las variables
  constructor(edad: number, altura: number, dni: string) {
    this.edad = edad;
    this.altura = altura;
    this.dni = dni
  }

}


class Alumno extends Persona {
  private matricula: string;

  constructor(edad: number, altura: number, dni: string, matricula: string) {
    super(edad, altura, dni) // para poder utulizar las propiedad de la clase padre 
    this.matricula = matricula;

  }
}

let persona: Persona = new Persona(27, 1.69, "123");
let alumno: Alumno = new Alumno(27, 1.69, "123", "123");

persona = alumno; //Toda persona es un alumno
//alumno = persona; //No todos alumnos son personas // Shapes 


```

### Union types

Habrá ocasiones en las que necesitemos asignar variables con más de un tipo, para evitar el uso de any debemos usar union types. Utilizando el signo ‘|’ podemos indicarle a TypeScript que utilice uno u otro tipo de dato, por ejemplo:

```ts
type SumaParameter = string | number;
```