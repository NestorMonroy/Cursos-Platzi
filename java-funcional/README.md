### Programación funcional

¿Qué es la programación funcional?
La programación funcional es una forma de programar, un estilo de programación. Es un estilo más enfocado a tener casos específicos en el cual nos preocupamos en qué resolver.
En Java veremos dos cosas:
Funciones
Datos

Básicamente la programación funcional se enfoca en qué resolver, no en cómo resolverlo.
Lo importante es tener una función que pueda resolver el problema, no importa su procedencia.
En la parte de los datos vamos a aprender que son los datos mutables e inmutables. Esto es muy importante porque nos va a diferentes tipos de funciones según los datos que tengamos.

Beneficios de la programación funcional

* Legibilidad: Vamos a estar enfocados en qué resolver es decir, nuestras funciones van a ser más explícitas en cuanto a qué es lo que hacen, no en cómo lo hacen.
* Testing: Va a ser más fácil hacer pruebas porque, al tener nuestras funciones separadas resolviendo pequeños problemas, es más fácil hacer una prueba de una sola función que tener que resolver todo el sistema.
* Concurrencia: Más fácil y didáctica porque podemos liberar muchos procesos simultaneos a partir de la misma función. No necesitamos tener control de los objetos que existen en memoria porque tenemos funciones únicas.
* Comportamientos más definidos: Estos comportamientos van a estar dados por funciones simples y vamos a poder leerlas rápidamente y entender qué es lo que hacen.
* Manejos de estados: Vamos a tener un menor manejo de estados. No vamos a preocuparnos por qué objeto tiene el dato en el momento que estamos funcionando sino que, nos vamos a enfocar más en simplemente si “tenemos el dato o no tenemos el dato”.

## ¿Qué es una función?

Una función es un tipo de dato que puede operar sobre una dato x y genera un valor y.
Igualmente, por cada x siempre genera una y. También es:

Serie de pasos parametrizados

Puede o no devolver un resultado

Se puede definir, almacenar o declarar bajo demanda (cómo cualquier otro tipo)

Podemos definir funciones con respecto a otras funciones (recursividad)

Podemos definir funciones que tomen a otras funciones como parámetros


Los de ciudadanos de primera clase, en realidad hablamos de algo que dentro del lenguaje de programación es usable y operable.

En el caso de Java tenemos por ejemplo:

* Tipos de dato primitivos
* Clases
* Objetos
* Interfaces
* Tipos Genericos
* Anotaciones
* Arreglos

Todos ellos son ejemplos de ciudadano de primera clase.


### Funciones puras


* Función pura: determinista (resultado predecible). Fácil de probar. Su resultado será siempre el mismo al recibir siempre los mismos parámetros. No dependen del contexto, siempre generará el mismo resultado y no generará efectos secundarios, es decir no afectará datos de entrada ni otros datos relativos a otros flujos de datos. No dependen del estado del sistema.

* Función impura: no determinista. Dependen del estado del sistema. Dependen de su contexto. Pueden generar efectos secundarios, es decir, pueden afectar a otros flujos de datos o verse afectadas por otros flujos de datos subyacentes. No son predecibles.

Una función pura puede invocar a una función pura, pero no a una impura. Si una función pura invoca a una impura se transformará entonces en una función impura ya que la naturaleza de la impura hará impredecible el resultado de la función pura, ya sea por resultado o por los efectos secundarios y contexto que impliquen la función pura.


### Entendiendo los efectos secundarios

Un efecto secundario es todo cambio observable desde fuera del sistema es un efecto secundario. Los efectos secundarios son inevitables (porque terminan siendo necesarios), algunos ejemplos son:

* CRUD sobre archivos
* CRUD sobre una base de datos
* Enviar/Recibir una llamada de red
* Alterar un objeto/variable usada por otras funciones.

Sin embargo, se deben reducir los efectos secundarios, porque ayuda a tener una mejor estructura del código (favoreciendo la generación de funciones puras, la modularidad y la testeabilidad).


### Funciones de orden mayor


Una función de orden mayor cumple al menos con una de estas características:
Toma otra función como parámetro
Retorna una función como resultado.
Funcion que resive una funcion y un json, y retorna otro json modificado

-Toma otra funciona como parámetro.
-Retorna una función después de su ejecución.

Ventajas:

* Pasar comportamiento
* Compartir un medio de comunicación (callbacks)
* Compartir lógica/reglas

### Funciones lambda

Función = Tiene un nombre.
Lambda = Función que no tiene un nombre.

Por qué usar lambdas?
Es un comportamiento único.
Es una regla que solo se requiere en un lugar.
Es una función muy simple (1 línea).

### Inmutabilidad

Inmutabilidad

Un objeto inmutable es aquel cuyo estado no se puede cambiar una vez construído.
Ventajas :
* Una vez creado no se puede alterar.
* Facilidad para crear funciones puras.
* Facilidad para usar threads/concurrencia.
Desventajas :
* Cuando se necesecite alterar un datos, se requiere crear una nueva instancia por cada set modificado.
* Requiere especial atención al diseño.
* Los objetos mutables están fuera de nuestro alcance, porque se vuelven inpredecibles.