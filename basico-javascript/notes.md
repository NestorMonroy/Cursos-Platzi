¿Qué es Javascript?
Es un lenguaje interpretado, orientado a objetos, débilmente tipado y dinámico.
Débilmente tipado
Se pueden hacer operaciones entre tipos distintos de datos (enteros con strings, booleanos con enteros, etc). Ejemplo:

```js
4 + "7"; // 47
4 * "7"; // 28
2 + true; // 3
false - 3; // -3
```

Dinámico

Corre directamente en la etapa de Runetime sin una etapa de compilación previa. Esto permite probar nuestro código inmediatamente; pero también es lo que hace que los errores se muestren hasta que se ejecuta el programa

¿Realmente es Javascript un lenguaje interpretado?

Si, y la razón es que le navegador lee linea por linea nuestro código el cuál le indica lo que tiene que hacer, sin la necesidad de compilar. Todo esto es controlado por el motor de Javascript V8 del navegador Javascript es Basckwards Compatible

Todas las funciones nuevas que salen de Javascript no dañarán el trabajo ya hecho, pero no se podrá utilizar en nuestro entorno de trabajo inmediatamente. Para solucionar esto está Babel que permite utilizar las nuevas características del lenguaje pero lo transforma a una versión que el navegador pueda entender.

WebAssembly: es un nuevo tipo de código que puede ser ejecutado en navegadores modernos es un lenguaje de bajo nivel, similar al lenguaje ensamblador, con un formato binario compacto que se ejecuta con rendimiento casi nativo y provee un objetivo de compilación para lenguajes como C/C++ y Rust que les permite correr en la web. También está diseñado para correr a la par de JavaScript, permitiendo que ambos trabajen juntos.

VALORES

PRIMITIVOS: son los valores básicos que se utilizan para poder generar códigos.

Número: data sólo de tipo numérico, ejem: 1 2 3 4, etc.

Strig: texto, se utiliza entre comillas dobles. “Haciendo esto”, “Diego Hernández”

Boolean o Booleano: son valores creados por George Boolean dentro de lenguajes de programación para poder validar cosas y/o desiciones, por ello se utilizan: true (1) o false (0).

Empty values: null o undefined, se les conoce como valores “placeholders”, pero son valores reservados para un tipo de valor que queda faltante en memoria. También pueden ser tomados como valores de errores.

NO PRIMITIVOS O VALORES TIPO OBJETOS:

Array: se genera ocupando corchetes, los cuales dentro ocupan valores primitivos, ejem: [1,2,3] convirtiéndolos en valores tipo objeto.
Valor tipo Objeto: se generan con corchetes, los cuales dentro ocupan una data que se transforma en objeto, ejem de sintaxis: { nombre: “Diego”}


https://jsconsole.com/



Diferencias entre var, const y let:

var: Es una variable que puede cambiar su valor en un futuro y su alcance es local. Surgió en ECMAScript5.

const: Es una variable constante que no puede cambiar nunca su valor en un futuro.

let: Es una variable que puede cambiar su valor pero solo funciona en un bloque donde se declare ( {let} )


```js
var name = 'Freddy Mercurio';
var age = 28;
name = 'Freddy Mercury'; // Suponemos que freddy se equivoco de nombre y luego lo quiso cambiar

const name = 'Kurt Cobaño'; // Kurt ya no puede cambiar el valor de const name

let age= 28; // let se puede cambiar por otro valor
let age = 20;
```

Las funciones son las tareas que va a llevar a cabo el navegador. Existen 2 tipos de funciones
1) Declarativas
2) De expresión

Ambas pueden llevar parámetros, que son los datos que necesitan para ejecutarse.

Cada parámetro va separado por una coma.

Cada instrucción que tenga la función debe terminar con ; .

Si queremos que una función nos dé un numero o dato tenemos que usar la siguiente sintaxis:

return El dato que queremos que nos dé;

Las funciones declarativas tienen la siguiente sintaxis:
function Nombre de la función (Parámetros de la función) {Instrucciones}

Las funciones de expresión son aquellas que guardamos en una variable, por lo tanto, no es necesario nombrarlas y tienen la siguiente sintaxis:
_var Nombre de la variable = function(Parametros){Instrucciones}.



```js

// Declarativas

function miFunction(){
  return 2
}
function suma (a,b) {return a+b;}


// Expresion o funcion anonima 

var miFuncion = function(a, b){
  return a + b
}

var suma = function(a,b){return a+b;}

```


Diferencias:
A las funciones declarativas se les aplica hoisting, y a la expresión de función, no. Ya que el hoisting solo se aplica en las palabras reservadas var y function.

Lo que quiere decir que con las funciones declarativas, podemos mandar llamar la función antes de que ésta sea declarada, y con la expresión de función, no, tendríamos que declararla primero, y después mandarla llamar.


*variables globales: ** Pueden ser accedidas desde un scope local o global. las variables globales son definidas fuera de las funciones (Scope global)

_**Scope local: **_Son aquellas variables definidas dentro del cuerpo de la función, estas son solo accedidas desde dentro de la misma función.

Scope Global: variables que pueden ser accedidas y procesadas por cualquier función dentro del código.


Hoisting es cuando las variables y las funciones se declaran antes de que se procese cualquier tipo de código. 

El Hoisting funciona de ECMAScript 5 para abajo, de ECMAScript 6 en adelante no sucede porque el Hoisting sucede con var y function. En las versiones de ECMAScript 6 en adelante aparece const y let.


Coerción es la forma en la que podemos cambiar un tipo de valor a otro.

Existen dos tipos:

Implícita: El lenguaje cambia los tipos de valores para que funcione el código.

Explicita: Es cuando nosotros obligamos a que una variable cambia de un tipo de valor a otro tipo.

¿Que tipos por default son verdaderos y falsos?

Usamos la función de JS que es Boolean() dentro del paréntesis ponemos el valor y nos dice si el mismo el False o True.

–> Falsy

Boolean() —> sin ningun valor es false
Boolean(0) —> false
Boolean(null) —> false
Boolean(NaN) —> false // NaN es Not and Number
Boolean(Undefined) —> false
Boolean(false) —> false
Boolean("") —> false

–> Truthy

Boolean(1) —> true //cualquier numero que no sea igual a cero es true
Boolean(“a”) —> true
Boolean(" ") —> true // siendo un espacio el valor es true
Boolean([]) —> true // un array nos da un true
Boolean({}) —> true // un objeto nos da el valor de true
Boolean(function() {}) —> true //una funcion tambien es true
Boolean(true) —> true
Todo esto lo vamos a usar en condiciones esto valida si es verdadero o falso para ejecutar cierta acción.

Enlaces a documentación en mozilla de Truthy y Falsy:
https://developer.mozilla.org/es/docs/Glossary/Falsy
https://developer.mozilla.org/es/docs/Glossary/Truthy


OPERADORES: ASIGNACION, LOGICOS Y ARITMETICOS

Operador de asignacion

Simbolo	Descripcion
=	operador de asignacion

Operadores de comparacion
Simbolo	Descripcion
==	igual que
===	estrictamente igual que
> or >= or >==	mayor o mayor igual que
< or <= or <==	menor o menor igual que
!= or !==	diferente que

Operadores aritmeticos
Simbolo	Descripcion
+	operador suma este se utiliza para concatener dos cadenas de texto.
-	operador resta
*	operador de multicacion
/	operador de division
%	operador de modulo
**	operador de potenciacion
tambien se les conoce como operadores binarios. por que toman dos valores y generan un resultado.

Operadores logicos
Simbolo	Descripcion
!	NOT niega un valor
&&	AND
||	OR