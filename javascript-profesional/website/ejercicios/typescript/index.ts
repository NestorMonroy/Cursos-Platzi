// Boolean

let muted: boolean = true
muted = false

//Numeros
let age = 6
let numerador: number = 42
let denominador: number = age

let resultado = numerador / denominador

//String
let nombre: string ='nestor'
let saludo = `me llamo ${nombre} `

//Arreglos
let people: string[] = []
people = ["Nestor", "Maria", "Joel"]

//people.push("999")

let peopleAndNumbers: Array< string | number > = []
peopleAndNumbers.push("Nestor")
peopleAndNumbers.push(123)

//Enum
enum Color {
  Rojo = "Rojo" ,
  Verde = "Verde",
  Azul = "Azul" , 
  Gris = "Gris"
}

let colorFavorito: Color = Color.Gris

//console.log(`Mi color favorito es ${colorFavorito} `)

//Any
let comodin: any = 'Joker'
comodin = { type: 'WildCard' }


//Object
let someObject: object = { type: 'WildCard' }

//Funciones 
function add(a: number, b:number): number {
  return a + b
}

const sum = add(4,6)

function createAdder(a: number): (number) => number {
  return function(b : number) {
    return b + a
  }
}

const addFour = createAdder(4)
const fourPlus5 = addFour(5)

function fullName(firstName: string, lastName: string = 'Smith') : string {
  return `${firstName} ${lastName} `
}

const nestor = fullName('Agente')

//console.log(nestor)

//Interfaces

interface Rectangulo {
  ancho: number,
  alto: number, 
  color?: Color
}

let rect: Rectangulo ={
  ancho: 5,
  alto: 8, 
  //color: Color.Azul
}

function area(r:Rectangulo ) {
  return r.alto * r.ancho
}

const areaRect = area(rect)
console.log(areaRect)

rect.toString = function(){
  return  this.color ? `Un rectangulo ${this.color}` : `Un rectangulo `
}

console.log(rect.toString())