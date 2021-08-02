### Que es TypeScript

Es un superconjunto tipado de javascript, que compila a javascript.

Lenguaje de programación tipado: Posee un conjunto de tipos para poder usarlos con las variables, pudiendo personalizarlos o extenderlos.

Lenguaje de alto nivel: Entendible por humanos y posee un alto nivel de abstracción del código máquina.

Genera como resultado código JavaScript: Emite código javascript compatible con browsers y otras herramientas de javascript.

Código abierto.

Desarrollo desde cualquier sistema.

El código puede ejecutarse en cualquier navegador o plataforma que soporte javascript.

### Porque usar TypeScript

* Programación orientada a objetos
* Potenciar tu código JavaScript
* Mayor productividad
* Poderoso sistema de tipos
* Compila a ES5, ES6 y más
* Proyecto muy activo/Open source
* Actualizaciones periódicas
* Comunidad creciente
* Puede prevenir cerca del 15% de bugs
* Puede usar TypeScript para backend


npm install typescript --save-dev


### Tipado en TypeScript

Explicito: 
-----------
Define una sintaxis para la creación de variables con tipo de dato
nomVariable : Tipo de dato
Inferido: TypeScript tiene la habilidad de deducir el tipo en funcion de un valor.

#Tipo de datos primitivos
--------
Number > Boolean > String > Array
Tuple > Enum > Any > Void
Null > Undefined > Never >Object

Tipos de datos

Dentro de los tipos explícitos que maneja TypeScript, tenemos:

Number. Este tipo de dato incluye valores numéricos, hexadecimales, binarios y octales.
```ts

// Explícito
let phone: number
phone = 3315015804
let hex: number = 0xf00d
let binary: number = 0b1010
let octal: number = 0o744
// Implícito
let phoneNumber = 3315015804

```

Boolean. Es el tipo de dato más simple en TypeScript ya que solo acepta dos tipos de valores que son true o false.

```ts
// Explícito
let isTrue: boolean = true

// Implícito
let isFalse = false

```   
String. Es el tipo de dato para trabanar con datos textuales o cadenas, para definir este tipo de dato se puede usar comilla dobles "" o simples ''.

```ts
// Explícito
let userName: string = 'Alejandra'

// Implícito
let lastName = 'Camacho'

```    

Dentro del tipo de dato string también podemos crear templates de la 
siguiente forma:

```ts
// Template string
// Uso de back-tick ``
let userInfo: string = `
  User info:
  firstName: ${firstName}
  lastName: ${lastName}
  phone: ${phone}
  isValid: ${isTrue}
`
```

### Tipo Any

* Usado para capturar valores dinámicos
* Los valores pueden cambiar de tipo en el tiempo:
    * APIs externas
    * Librerías de terceros
    
Any no es recomendado. Solamente debería usarse cuando no sabemos qué tipo de dato almacenará nuestra variable.


### Void y never

Tipo Void: Representa la ausencia de tipo. usado en funciones que no retornan nada.

Tipo Never: Representa funciones que lanzan excepciones o nunca retornan un valor.

### null y undefined

En TypeScript, ambos “valores” tienen sus respectivos tipos:

* null
* undefined

Null y Undefined se pueden asumir como subtipos de los otros tipos dedatos.
Significa que se pueden asignar null y undefied a una variable de tipostring, por ejemplo.

### Opción --strictNullChecks

Solo permite asignar null y undefined a una variable de tipo any o a sus respectivos
Ayua a evitar errores comunes en programación de apps en el ámbito JavaScript

Generará un reporte de los errores que encuentre, hacemos tsc nombreDelArchivo.ts --strictNullChecks


### Object vs object

* Object: instancia de la clase Object en JavaScript
* object: tipo para valores no primitivos

Con este tipo no se puede acceder a las propiedades del objecto

Esto es lo que dice la documentacion de typescript: Generally, you won’t need to use this. En pocas palabras, ignoren el tipo object.

Tengo entendido que {}, es decir, Object, es mejor que object.

### Array

Al igual que en JavaScript, TypeScript permite definir un arreglo para contener un conjunto de valores, 
para definir los arreglos se pueden usar nos notaciones [] y Array<type>.

```js
// Corchetes []
const nickname: string[] = ['Syaan', 'Matt', 'Lou']
const idNumber: number[] = [1, 2, 3, 4, 5]
// Array<type>
const pictureTitles: Array<string> = ['Favorite Sunset', 'Vacation Time', 'Landscape']

```

### Tupla

Permite expresar un arreglo con un numero fijo de elementos. Los tipos de datos son conocidos.
Asi se crean las tuplas. diferente tipos de datos

```js
let userInfo = [number,string];
userInfo = [1,'danijazzero'];

```
Se accede con indices.

```js
userInfo[0]; // esto es 1
userInfo[1]; // esto es 'danijazzero'

```

Definimos arreglo de tuplas

```js
let usersInfo = [number,string][] = [];
//usamos push para agregar users a usersInfo
```


#### Enum

Permiten definir un conjunto de constantes con nombre.
Tienen la ventaja de adaptarse al contexto de la aplicacion.

```js
// crear
enum PhotoOrientation {
	Landscape,
	Portrait,
	Square,
	Panorama
}
// utilizar
const landscape: PhotoOrientation = PhotoOrientation.Landscape
```
### Unión de Tipos, Alias y Tipos Literales
Unión de Tipos
* En TypeScript se puede definir una variable con múltiples tipos de datos: Union Type
* Se usa el símbolo de pipe | entre los tipos

Alias de Tipos

* TypeScript permite crear un alias como nuevo nombre para un tipo
* El alias se puede aplicar también a un conjunto de combinación de tipos
* Se usa la palabra reservada type

Tipos Literales

* Una variable con un tipo literal puede contener únicamente una cadena del conjunto
* Se usan cadenas como “tipos”, combinados con el símbolo de pipe | entre ellos

```js
export {}

//* Por ejemplo, tenemos usuarios que tienen un ID numérico o de tipo string 10, '10'
let idUser: number | string //* Aceptará strings y number
idUser = 10
idUser = '10'

//* Buscar username dado un ID

function getUserNameById(id: number | string) {
  //* Lógica de negocio, find the user
  return id
}

//* No da errores 😄
getUserNameById(10)
getUserNameById('10')

//--------------------------------------------------------------------------------------------

//* Alias de tipos de TS
type IdUser = number | string
type UserName = string
let userID: IdUser
idUser = 10
idUser = '10'

//* Buscar username dado un ID

function getUserName(id: IdUser): UserName {
  //* Lógica de negocio, find the user
  return 'Mike'
}

//----------------------------------------------------------------------------------------------------

//* Tipos literales
//* Por ejemplo, sólo aceptamos fotos de 100x100, 500x500 y 1000x1000
type SquareSize = '100x100' | '500x500' | '1000x1000'
//! let smallPicture: SquareSize = "200x200" //!Esto da un error, no está incluido ese valor en SquareSize
let smallPicture: SquareSize = "100x100"
let mediumPicture: SquareSize = "500x500"
let bigPicture: SquareSize = "1000x1000"

console.log('small Picture: ', smallPicture)
console.log('medium Picture: ', mediumPicture)
console.log('big Picture: ', bigPicture)
```

### Aserciones de tipo

Mecanismo de conversión de tipos de datos. Se parece al casting de tipos en otros lenguajes de programación.
Usa dos sintaxis.

```ts
//Angle Bracket: <Type>
let username : any;
username = (<string>'ejemplo1').toUpperCase();
///as: variable as type
username = (username as string).toLowerCase()
```

### Funciones en TS

* Los parametros en las funciones son tipados
* Se pueden definir parametros opcionales
* Se puede definir que tipo de datos devolvera la funcion

```ts
type SquareSize = '100x100' | '500x500' | '1000x1000';

// el simbolo ? indica que el parametro es opcional. 
// Siempre que tengamos un parametros opcional tiene que encontrasrse al final
// en caso de que no resivamos este parametro opc va a tomar el valor pode default
function createPicture(title: string, date: string, size?: SquareSize = "100x100"){
	
}

// Fat Array Function
let createPic = (title: string, date: string, size?: SquareSize): object => {
	return {
		title,
		date,
		size
	}
};
```

### 

Usar never cuando vamos a lanzar excepciones en la función.
Al momento de usar la función, ponerlo en un try catch.

null y undefined son subtipos de void. A su vez, null y undefined son subtipos de :

* number
* boolean
* string
* array
* tuple
* enum
* any
* void
* object

### Interfaces

Las interfaces en TS constituyen una forma poderosa de definir “contratos” tanto para tu proyecto, como para el código externo del mismo.

Documentación oficial sobre interfaces en TS

https://www.typescriptlang.org/docs/handbook/2/objects.html#interfaces-vs-intersections

```ts
//* Función para mostrar una fotografía
export {}

enum PhotoOrientation{
  Landscape,
  Portrait,
  Square,
  Panorama
}

interface Picture {
  title: string,
  date: string,
  orientation: PhotoOrientation
}

function showPicture(picture: Picture) {
  console.table({picture}) //* Imprime una tabla con los datos del objeto, se ve muy profesional
}

let myPic = {
  title: 'Test title',
  date: '2020-03',
  orientation: PhotoOrientation.Landscape
}

showPicture(myPic)
showPicture({
  title: 'Another title',
  date: '2021-06',
  orientation: PhotoOrientation.Portrait
})
```

#### Interfaces: propiedades opcionales

No todas las propiedades de una interfaz podrían ser requeridas.

Establecemos una propiedad como opcional con el símbolo ‘?’ después del nombre.

```ts
interface PictureConfig {
  title?: string, //* El '?' indica que el parámetro es opcional
  date?: string,
  orientation?: PhotoOrientation
}

function generatePicture(config: PictureConfig) {
  const picture = {title: 'Default title', date: '2020-01-01'} //*Valores por defecto
  if (config.title) {
    picture.title = config.title
  }
  if (config.date) {
    picture.date = config.date
  }

  return picture
}

let picture = generatePicture({})
console.table({picture})

picture = generatePicture({title: 'Travel Pic'})
console.table({picture})

picture = generatePicture({title: 'Travel Pic', date: '2016-06-23'})
console.table({picture})

```
Interfaces: Propiedades de solo lectura

Algunas propiedades de la interfaz podrían no ser modificables una vez creado el objeto. Esto es posible usando readonly antes del nombre de la propiedad.

```ts
//* Interfaz: Usuario

interface User {
  readonly id: number,
  username: string,
  isPro: boolean
}

let user: User = {id: 10, username: 'Mike', isPro: true}
console.table({user})
//*modificamos ahora un campo
//! user.id = 20 ahora no podemos modificar este campo
user.username = 'paparazzi'
console.table({user})

```


### Extendiendo Interfaces.

Las interfaces pueden extenderse unas de otras. Esto permite copiar los miembros ya definidos en una interfaz a otra, ganando flexibilidad y reusabilidad de componentes.
Utilizamos la palabra reservada extends para utilizar herencia.

```ts
interface Person {
name:string;
lastname:string;
}
interface Student extends Person {
person:Person
}
```