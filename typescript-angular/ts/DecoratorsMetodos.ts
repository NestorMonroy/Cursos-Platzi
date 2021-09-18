
///target => elemento que contenga
//key => quien utiliza la logica extendida
function logExample(target, key){
  console.log(key + "Se ha llamado")
}

class Persona {
  private name: string;

  constructor(name: string) {
    this.name = name;
  }

  @logExample
  sayMyName() {
    return console.log(this.name);
  }
}


const persona: Persona = new Persona("Nestor");
persona.sayMyName(); //Nestor //sayMyName se ha llamado se imprimen las dos cosas
