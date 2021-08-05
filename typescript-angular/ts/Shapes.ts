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

