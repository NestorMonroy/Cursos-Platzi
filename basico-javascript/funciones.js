function saludar(nombre) {
	console.log(`Hola ${nombre}`);
}

saludar('Diego');

//Expresión de función:

// En la expresión de función, la declaración se inicia con la palabra reservada var, 
// donde se generará una variable que guardará una función anónima.

var nombre = function(nombre){
  console.log(`Hola ${nombre}`)
}

nombre("Nestor");


function sumar(a, b) {
  var res = a + b;
  return res;
}

sumar(5, 10);



