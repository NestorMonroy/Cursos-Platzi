var hello = "Hello";
var hello = "Hello ++";
let world = "Hello World";

const helloWorld = "Hello World";

const anotherFunction = () => {
  console.log(hello);
  console.log(world);
  console.log(helloWorld);
};

anotherFunction();
//Mala practica
const helloWorld = () => {
  globalVar = "Im global";
};

helloWorld();
console.log(globalVar);


const anotherFunction = () => {
  var localVar = globalVar = 'Soy global'
}

anotherFunction()
console.log(globalVar)
