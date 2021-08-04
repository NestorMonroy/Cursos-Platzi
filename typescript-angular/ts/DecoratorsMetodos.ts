
///target => elemento que contenga
function log(target, key){
  console.log(key + "Se ha llamado")
}

class Persona {
  private name: string;

  constructor(name: string) {
    this.name = name;
  }

  @log
  sayMyName() {
    return console.log(this.name);
  }
}


const persona: Persona = new Persona("Nestor");
persona.sayMyName(); //Nestor //sayMyName se ha llamado se imprimen las dos cosas
