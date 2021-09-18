function logProperty(target, key) {
  let _val = this[key];

  //Get retorna el valor que regresa
  const getterVal = () => {
    console.log(`Get: ${key} ==> ${_val} `);
    return _val;
  }

  //Set Asigna el nuevo valor
  const setterVal = (newValue) => {
    console.log(`Set: ${key} ==> ${newValue}`);
    _val = newValue;
  }

  //Sobre escribir las propiedades del objecto, para poder utilizar get
  const objectProperty = {
    get: getterVal,
    set: setterVal
  }

  //Se asgina la funcionalidad al Objeto
  Object.defineProperty(target, key, objectProperty)

}

class Persona {
  @logProperty
  public name: string;

  constructor(name: string) {
    this.name = name;
  }


}

const p = new Persona("Nestor")
p.name = 'Otro'// Set: name ==> Otro
const nameFromClass = p.name //Get: name ==>  otro

