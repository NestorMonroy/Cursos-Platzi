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

