//aqui se da el hoisting en las variables
//donde la variable es usada antes de ser declarada

console.log(miNombre);
var miNombre = "Nestor";

hey();

function hey() {
    console.log("hola " + miNombre);
}

var miNombre = "Nestor";

//Lo ideal es que se declaren la funciones al inicio