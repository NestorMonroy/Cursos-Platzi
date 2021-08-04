//Log de parametros 
function logParameter(target, propertyName, index) {
  const metadataKey = `log_ ${propertyName}_parameters`;
  //Validacion que sea un array
  if (Array.isArray(target[metadataKey])) {
    //Incluir todos los index
    target[metadataKey].push(index);
  } else {
    //Que sea a un array unico elemento index
    target[metadataKey] = [index];
  }
}


class P {
  //Se hace llamado al decorador para aplicarlo al message 
  greet(@logParameter message: string): string {
    return message;
  }
}

const p = new P();
p.greet('Hola');