https://developer.mozilla.org/en-US/docs/Web/API/HTMLMediaElement

En JavaScript no exiten las clases, lo que existen son objectos
Para agregar metodos a estas clases se agregan al prototype 

El DOM es la representación que hace el navegador de un documento HTML.

El navegador interpreta el archivo HTML y cuando termina de transformarlo al DOM se dispara el evento DOMContentLoaded lo que significa que todo el documento está disponible para ser manipulado.

Tanto con async como defer podemos hacer llamados asíncronos pero tiene sus diferencias:

async. Con async podemos hacer la petición de forma asíncrona y no vamos a detener la carga del DOM hasta que se haga la ejecución del código.

defer. La petición es igual asíncrona como en el async pero va a deferir la ejecución del Javascript hasta el final de que se cargue todo el documento.

scripts embebidos: el navgador carga linea a linea el html y cuando se encuentra un codigo entre scripts va a deter su ejecución hasta que hallá procesado todo el script.

Scope

El Scope o ámbito de una variable, es lo que define el tiempo de vida de una variable, en que partes de nuestro código pueden ser usadas.

Toda variable que se declare fuera una funcion, queda disponible en el scope global (window)

Global Scope Variables disponibles de forma global se usa la palabra var, son accesibles por todos los scripts que se cargan en la página. Aquí hay mucho riesgo de sobreescritura.

Function Scope Variables declaradas dentro de una función sólo visibles dentro de ella misma (incluyendo los argumentos que se pasan a la función).

Block Scope Variables definidas dentro de un bloque, por ejemplo variables declaradas dentro un loop while o for. Se usa (let y const) para declarar este tipo de variables.

Module Scope(Babel) Cuando se denota un script de tipo module con el atributo type="module las variables son limitadas al archivo en el que están declaradas. no los vamos a poder leer 
en consola porque el module scope está limitando el alcance

Clouseres **

clouseres o clausuras es la union del scope y funciones, Establecer valores definidos y crear nuevas funciones para trabajar sobre estos valores

This

This se refiere a un objeto. Ese objeto es el que actualmente está ejecutando un pedazó de código.

this en el objeto global -> window

Métodos Call, Apply y Bind

This no es un valor que podemos asignar directamente, no podemos escribir this = 'valor', pero si existen unos métodos que son parte del prototipo de function (call, apply, bind).Estos 3 métodos nos van ha ayudar a establecer cual es el this que va ha ser el contexto de la llamada a una función .

Todas las funciones tienen (call, apply, bind)
