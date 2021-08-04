## Clases del Curso de TypeScript con Angular por Belatrix

### ¿Qué es Typescript?

TypeScript es un lenguaje fuertemente tipado creado por Microsoft, aunque está muy relacionado con el framework Angular, TypeScript es un lenguaje independiente que puedes usar para proyectos de back-end con Express o Front-end ya sea con Vue, React o Angular. Para que TypeScript pueda correr en el navegador debe ser transpilado a JavaScript con herramientas como Babel.

VS ESLint tslint plugins

<img src="./static/images/ts_001.jpg" with="20%"/>

----------------

### Types, Type Inference y Type keyword

A diferencia de JavaScript, TypeScript es un lenguaje fuertemente tipado. Mientras que en JavaScript declaramos una constante de la siguiente manera:

const a = 'hola'

En TypeScript utilizando el carácter ‘:’ le asignamos un tipo de dato a la variable :

const a: string = 'hola'

En caso de que no le asignemos un tipo de dato a la variable, TypeScript automáticamente le va a asignar un tipo de dato, esto es el Type Inference.

Si le asignamos el tipo de dato any a una variable, esta variable va a poder almacenar cualquier tipo de dato, similar a JavaScript Vainilla.

Dentro de TypeScript contamos con la palabra reservada type que nos va a ser de utilidad cuando hagamos nuestros propios tipos de datos.


