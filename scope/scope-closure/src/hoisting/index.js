//lo que ocurre es que al momento de compilar
//javascript ordena y pone primero la declaracion y luego la asignacion
//hoisting eleva las declaraciones 
// solo se utiliza en declaraciones y no en las inilizaciones

a = 2;
var a;
console.log(a); // la ejecuacion muestra 2

//igual que lo anterior. El motor del lengua, lo que haces es que lee todas las declaraciones
//y por eso de esta forma al hacer la ejecucion encuentra lo que esta buscando

console.log("tomi");
nameOfDog('otro')
function nameOfDog(name) {
  console.log(name);
}

nameOfDog('otro')