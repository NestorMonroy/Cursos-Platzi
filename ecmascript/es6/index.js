function newFuncion(name, age, country) {
	var name = name || 'nestor';
	var age = age || 30;
	var country = country || 'MX';

	console.log(name, age, country);
}

// es6
function newFuncion2(name = 'nestor', age = 30, country = 'mx') {
	console.log(name, age, country);
}
newFuncion2();
newFuncion2('Joel', 22, 'co');

let hello = 'Hello';
let world = 'World';

let epicPharese = hello + ' ' + world;
console.log(epicPharese);

let epicPharse2 = `${hello} ${world}`;
console.log(epicPharse2);


let lorem = "bla bla bla \n"
+ "bla2 bla2 bla2"

// es6
let lorem2 = `bla bla bla 
bla2 bla2 bla2 
`

console.log(lorem)
console.log(lorem2)


// destructuracion de elementos

let person = {
  'name': 'nestor',
  'age': 30,
  'country': 'MX'
}

console.log(person.name, person.age)

let {name, age, country} = person
console.log(name, age, country)

// union de elementos

let team1 = ['nestor', 'joel', 'ricardo']

let team2 = ['valeria', 'jessica', 'camila']

let education = ['david', ...team1, ...team2]

console.log(education)


// let elementos en memoria, solo disponible en el bloque de codigo en el cual esta llamado
// var de forma global
// const no cambia su valor

{
  var globalVar = "Global Var"
}

{
  let globalLet = "Global let"
  console.log(globalLet)
}

console.log(globalVar)
console.log(globalLet)

const a = 'b'
a = 'a'
console.log(a)

let name = 'nestor'
let age = 30
// es5
obj = { name : name, age: age}
// es6
obj2 = {name, age}

console.log(obj2)

const names = [
  {name: 'nestor', age: 30},
  {name: 'joel', age:31}
]

let listOfNames = names.map(function(item){
  console.log(item.name)
})

let listOfNames2 = names.map(item => console.log(item.name))

const listOfNames3 = (names, age) => {
  
}

const listOfNames4 = name => {

}

const square = num => num * num


//promesas se trabaja el asyncronismo

const helloPromise = () => {
  return new Promise((resolve, reject) => {
    if(false){
      resolve("hey ok")
    } else {
      reject("ups bad")
    }
  })
}

helloPromise()
  .then(response => console.log(response))
  //.then(() =>  console.log('Hola'))
  .catch(err => console.log(err))


class Calculator {
  constructor(){
    this.valueA = 0
    this.valueB = 0    
  }
  sum(valueA,  valueB){
    this.valueA = valueA
    this.valueB = valueB

    return this.valueA + this.valueB
  }
  
}

const calc = new Calculator()
console.log(calc.sum(2,2))

import {hello} from './module'
hello()

function* helloWorld(){
  if (true){
    yield 'Hello ,'
  }
  if(true){
    yield 'World'
  }
}

const generatorHello = helloWorld()
console.log(generatorHello.next().value)
console.log(generatorHello.next().value)
console.log(generatorHello.next().value)

