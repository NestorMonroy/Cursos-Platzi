Scope: Es el alcance que va a tener una variable dentro del código. En otras palabras, el Scope se encargará de decidir a que bloques de código va a acceder una variable.

Global Scope : No están dentro de funciones o bloques, por lo tanto se puede acceder a ellas de manera global.

Con var podemos re-asignar una variable pero es una mala práctica.

Con let y const no podemos, aparecerá un error.

Es una mala práctica crear una variable sin las palabras reservadas: var, let y const.
Si se asigna una variable dentro de una función sin las palabras reservadas será una variable global.

La doble asignación de una variable también es una mala práctica.


Ámbito léxico significa que una función busca variables en el contexto donde se definió, y no en el ámbito que la rodea.

```js
//ejemplo de ambito lexico
let hello = "hello"
{
  let world = "world"
  {
    let js = "javascript"
    {
      const funcion = () => {
        return `${hello} ${world} ${js}`
      }
      //la funcion puede alcanzar las variables definidas en bloques superiores
      console.log(funcion())
    }
  }
}

```

Las variables escritas con la palabra clave var pueden ser redeclaradas, pero esto a futuro puede darnos problemas, así que es mejor no usarla.

Las variables escritas con la palabra clave let no pueden ser redeclaradas, si lo haces mostrara un “error: esta variable ya ha sido declarada” , pero su valor puede ser reasignado:

```js
let fruit = "apple";
fruit = "banana";

console.log(fruit); // banana
```

Las variables escritas con la palabra clave const no pueden ser redeclaradas o reasignadas, ya que const quiere decir que su valor será constante, es decir que no va a cambiar.

Dentro de una función podemos tener un bloque de código, por ejemplo: un if, mientras lo llamamos sobre una llave estará guardado dentro de un bloque.

Si definimos un elemento con var podemos acceder en todos los elementos de la función, si lo llamamos fuera del bloque donde está, vamos a poder acceder a ese elemento.

Con let y const no vamos a poder acceder a ellos porque se establecen dentro del bloque, solo se puede acceder a ellos dentro de ese bloque.


Una clausura o closure es una función que guarda referencias del estado adyacente (ámbito léxico). En otras palabras, una clausura permite acceder al ámbito de una función exterior desde una función interior. En JavaScript, las clausuras se crean cada vez que una función es creada.

un closure recuerda el ambito donde ha sido creado


El ámbito léxico es cuando las funciones se ejecutan utilizando la cadena del alcance donde estaban vigente en su momento.

Esto significa que podemos acceder al valor “count” dentro de la función porque es el alcance donde está asignado.


Variables privadas con Closures: 

JS por su naturaleza no fomenta el uso de datos privados pero por medio de los Closures podemos crear valores que solo puedan ser accedidos por medio de métodos, que no van a estar disponibles fuera de esta función.


Podemos crear Closures de diferentes formas y también de forma involuntaria, esto significa que no tenemos control de lo que estamos creando, tenemos que tener cuidado con nuestras asignaciones o bloques de código que de alguna manera nosotros no controlemos muchas veces sucede porque no establecimos nuestros elementos correctamente.

Con el uso del Scope y los Closures podemos optimizar nuestros proyectos sin ningún problema.

```js

const anotherFunction = () => {
  for (var i = 0; i < 10; i++) {
    setTimeout(() => {
      console.log(i);
    }, 1000);
  }
};
anotherFunction();

const another = () => {
  for (let i = 0; i < 10; i++) {
    setTimeout( () => {
      console.log(i)
    }, 1000)
  }
}
another()

```

https://www.youtube.com/watch?v=uI6o97A4IrI&t=1s

Hoisting: Eleva las declaraciones, esto pasa en el momento en que se compila nuestro código antes de ser interpretado por el navegador.

De esta forma podemos asignar nuestros valores o acceder a un valor que previamente no ha sido declarado dentro de esta estructura.

-------------------------
El scope es el alcance de una variable en determinada parte de un programa
R = Verdadero

¿Qué es Code Runner?
R = Es un plugin de Visual Studio Code que permite ejecutar el código dentro del editor

¿Qué representa el siguiente código?
const fruits = () => { var fruit = 'apple'; console.log(fruit); }
R = Local Scope

JavaScript solo utiliza el hoisting en declaraciones, mas no en inicializaciones
R = Verdadero

¿Qué sucederá si ejecutamos el siguiente código?
nameOfDog("Elmo"); 
function nameOfDog(name) 
{ console.log(name); };
R = Se muestra en consola el siguiente mensaje: "Elmo"

Las variables declaradas con let y const, NO se pueden volver a declarar en el mismo ámbito.
R = Verdadero

¿La herramienta de Google Chrome que nos permite hacer debugging se llama?
R = Chrome DevTools

El uso de variables globales en nuestro código, ¿debería ser evitado?
R = Verdadero

Variables declaradas con "let" y "const" son de "block scope"
R = Verdadero

¿Cuál de los siguientes códigos es un closure?
R = const buildCount = (i) => { let count = i; const displayCount = () => { console.log(count++); }; return displayCount; }

¿Cuál es la sección de Chrome DevTools donde podemos depurar el scope?
R =Sources

¿Cuál de las siguientes opciones NO se puede considerar como una variable global?
R = var = "I am global";

Analiza el siguiente código e identifica la variable declarada en el alcance de la función
const fruits = () => { 
	if (true) { 
		var fruit1 = 'apple'; 
		const fruit2 = 'banana'; 
		let fruit3 = 'kiwi'; 
		} 
} 
R = var fruit1 = 'apple';

Analiza el siguiente código:
const helloWorld = () => { globalVar = "I'm global"; } helloWorld();
¿Cómo se crea la variable globalVar?
R = globalVar se crea como una variable global
