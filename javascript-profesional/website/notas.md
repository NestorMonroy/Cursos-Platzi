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

Call - comma
Apply - arreglo

bind no va a llamar la función automáticamente sino que va a construir una nueva función, está nueva función va a tener el this que le pasamos ya integrado y cuando llamemos ha está nueva función se va a ejecutar.

Call y Apply van a establecer el this y va a llamar la función inmediatamente, bind va a crear una nueva función donde this estará guardado y luego tocará guardar y ejecutar esa nueva función.

Prototype **

La regla que usa new cuando hace el Object.create es que siempre va a sacar el prototype de lo que sea el constructor

Herencia Prototipal **

Por default los objetos en JavaScript tienen cómo prototipo a Object que es el punto de partida de todos los objetos, es el prototipo padre. Object es la raíz de todo, por lo tanto tiene un prototipo padre undefined.

Cuando se llama a una función o variable que no se encuentra en el mismo objeto que la llamó, se busca en toda la prototype chain hasta encontrarla o regresar undefined.

La función hasOwnProperty sirve para verificar si una propiedad es parte del objeto o si viene heredada desde su prototype chain.
SomeObject.prototype es un objeto donde definimos el prototipo de las instancias de SomeObject. Es decir, las instancias de SomeObject van a "heredar" de SomeObject.prototype.
SomeObject.[[Prototype]] es el prototipo de SomeObject. Es decir, SomeObject "hereda" de SomeObject.prototype.