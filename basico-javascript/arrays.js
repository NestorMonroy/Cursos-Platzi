var frutas = ["Manzana", "Plátano", "Cereza", "Fresas"];

console.log(frutas);

console.log(frutas.length); // lingitud o numero de elementos
console.log(frutas[0]); // acceder al elemento por medio de index

//Mutar o alterar Array
var masFrutas = frutas.push("Uvas"); //añadir elementos al final del array
//console.log(masFrutas)
var ultimo = frutas.pop(); //Eliminar el último elemento del Array
//console.log(ultimo)
var nuevaLongitud = frutas.unshift("Uvas"); //añadir elemento al inicio del array
console.log(nuevaLongitud)
console.log(frutas)
var borrarFruta = frutas.shift("Uvas"); //Borrar elemento
//console.log(borrarFruta)
var posicion = frutas.indexOf("Cereza"); //Devuelve el index o posicion del elemento```
//console.log(posicion)
