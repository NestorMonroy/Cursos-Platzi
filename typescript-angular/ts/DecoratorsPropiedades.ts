function logProperty(target, key) {
  let _val = this[key];

  const getterVal = () => {
    console.log(`Get: ${key} ==> ${_val} `);
    return _val;
  }

  const setterVal = (newValue) => {
    console.log(`Set: ${key} ==> ${newValue}`);
    _val = newValue;
  }

  //Sobre escribir las propiedades del objecto, para poder utilizar get
  const objectProperty = {
    get: getterVal,
    set: setterVal
  }

  Object.defineProperty(target, key, objectProperty)

}

class Persona {
  public name: string;

  constructor(name: string) {
    this.name = name;
  }


}

const p = new Persona("Nestor")
p.name = 'Otro'// Set: name ==> Otro
const nameFromClass = p.name //Get: name ==>  otro

