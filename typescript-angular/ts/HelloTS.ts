let a: string = 'Hola';
a = 'Hola :)';
//a = 2; //Error

let b: number = 10;

//b='a'; //error

b = 20;
b = 10 + 10;

const num1 = 10;
const num2 = 10;
b = num1 + num2;


function suma(num1: number, num2:number): number{
    return num1 + num2
}

suma(5, 'n');

function sumaJavascriptVanilla(num1,num2){
    return num1 + num2
}

sumaJavascriptVanilla(10,5)

//No se sabe el tipo de valor
let anyValue: any = 10;
anyValue = '10';

//Crear un alias para facilitar el cambio en un futuro 
type dni = string;
// type es igual a alias
// let dniNumer: dni = 2155; //Error