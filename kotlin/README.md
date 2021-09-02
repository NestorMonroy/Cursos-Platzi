
<img src="./static/images/kotlin.png" style="width:50%;"/>

### Qué es la Java Virtual Machine

Una virtual machine es una virtualización o simulación de un sistema operativo o de los procesos que ocurren dentro de este. En nuestro caso, la Java Virtual Machine pertenece al segundo tipo y se encarga de simular los procesos que ocurren dentro de un sistema operativo. A este tipo de máquinas virtuales se les llama Process Virtual Machines.

### ¿Qué ventaja nos da?

Nos ayuda a manejar los punteros y las referencias de memoria que en otros tipos de lenguaje como C o C++ hay que manejar manualmente. Para esto se utiliza un proceso llamado garbage collection. Este proceso se encarga de revisar qué referencia de memoria no se está utilizando para eliminarla y así reducir la cantidad memoria que puede consumir un programa.

### ¿Cómo funciona la JVM?

La JVM funciona como un punto medio entre el código que nosotros escribimos y lo que entiende el sistema operativo del ordenador. Dependiendo del sistema operativo que uses puede variar. La JVM nos ayuda a que nuestro código se ejecute en Linux, Windows y MacOS. Nuestro código es convertido por la JVM a un lenguaje que puede entender el sistema operativo llamado Java Bytecode.

En palabras más simples, nosotros ingresamos código de Kotlin y se transforma en Bytecode. Este proceso puede ocurrir con otros lenguajes como Java, esto hace que nuestro código de Kotlin pueda ser utilizado desde Java y el código de Java pueda ser utilizado en Kotlin.


<img src="./static/images/kotlin_924.png" style="width:50%;margin-left: auto; margin-right: auto"/>



### Carpetas y ficheros a la izquierda

SI inician con un ** punto “.” **, guardan información de nuestro proyecto.

* “gradle” es un sistema de compilacion de Android
* "build" carpeta que almacena el codigo compilado por gradle
* "src" carpeta más importante donde se encuentra nuestro codigo
* _‘main.kt’ _ fichero que sirve como punto de entrada para el desarrollo de nuestra app
* "test" carpeta de tests necesarios para la app
* _‘build.gradle.kts’ _ fichero que contiene la configuración de como funciona el proyecto, versiones, dependencias, etc.
* _‘gradle.properties’ _ fichero que permite declarar propiedades del proyecto
* ’seetings.gradle.kts’ fichero para especificar propiedades del proyecto


### Variables en Kotlin

var = valores que pueden cambiar
val = valores que no pueden cambiar
const val = valores que no deben camiar nunca, se declaran fuera de las funciones

Declarar variables

{var/val/const val} {nombreVariable} : {Tipo de dato (opcional)} = {valor}


```java
const val PI = 3.1415 //constante

fun main(args: Array<String>) {
    println("Hello World!")
    var optionA = 80 //variable mutable
    println( "numero: "+optionA)
    optionA = 50
    println( "numero cambiado: "+  optionA )

    val name = "susana" //variable inmutable
    println("name: "+ name )
    println("pi"+PI)

```

### Modificadores y tipos de datos en Kotlin

¿Qué es un dato primitivo
Tipos de datos originales de un lenguaje de programación. En Kotlin lo son los enteros, booleanos y cadenas de texto

¿Qué es un objeto
Es una combinación de variables, funciones y otros objetos.
En Kotlin todo es un objeto, se convierten los datos primitivos a un objeto para obtener algunas ventajas como:

Crear funciones especificas para el objeto que ayuden a no reescribir el código

Sobrescribir operadores como la suma o multiplicación

-Enteros
-Cadenas de texto
-Booleanos

Comparten en común que son primitivos ya que vienen directamente con el lenguaje, con ellos se pueden crear objetos.

### Operaciones con los tipos de datos en Kotlin

En Kotlin las operaciones son traducidas a funciones interiormente por el compilador. La operación val tercerValor = primerValor + segundoValor es lo mismo que decir tercerValor = primerValor.plus(segundoValor).

En la siguiente tabla te voy a dejar las operaciones que vas a poder realizar con los distintos tipos de datos y si te encuentras con alguno que no permita realizar esa operación puedes crearla por tu cuenta. Recuerda que Kotlin te permite extender el lenguaje para aprovechar estas funcionalidades.

Operaciones más utilizadas

|Expresión |	Función 	|Operator Fun|
|----------|------------|--------------|
|a + b 	| c = a + b |	public operator fun plus(other: Int): Int|
|a - b 	|c = a - b 	|public operator fun minus(other: Int): Int|
|a * b 	|c = a * b 	|public operator fun times(other: Int): Int|
|a / b 	|a = a / b 	|public operator fun div(other: Int): Int|
|a % b 	|c = a % b 	|public operator fun rem(other: Int): Int|
|a++ 	  |c = a++ 	  |public operator fun inc(): Int|
|a– 	  |c = a– 	  |public operator fun dec(): Int|
|a > b 	|c = a > b 	|public override operator fun compareTo(other: Int): Int|
|a < b 	|c = a < b 	|public override operator fun compareTo(other: Int): Int|
|a >= b  |c = a >= b |public override operator fun compareTo(other: Int)|: Int|
|a <= b |c = a <= b |public override operator fun compareTo(other: Int)|: Int|
|a != b |c = a != b 	|public open operator fun equals(other: Any?): |Boolean|

Dependiendo del tipo de dato que tengas podrás utilizar todos o solamente algunas de estas operaciones, por ejemplo si tienes una variable del tipo de dato String no vas a poder dividirla, a menos que tú crees esa función. Sin embargo, sí vas a poder sumar dos variables del tipo de dato String para obtener el valor de dicha suma.

Con esto espero que hayas obtenido una idea sobre cómo funcionan las operaciones, queda de parte de ti si prefieres utilizar la versión larga del operator fun o el operador directamente.

Ten en cuenta que si las operator fun se inventaron para que puedas reducir tu código a operaciones con símbolos ¿por algo será, no?


### Paradigmas de la programación:

Son formas de escribir código.

* Paradigma Imperativo: Se basa en modificar variables de estado que se encuentran dentro del programa y así hacer que el código realice las tareas que quieres.

* Paradigma declarativo: programacion funcional Nos ayuda a entender que es lo que tiene que hacer un programa, como hace las cosas el programa.



### CONDICIONAL IF

Es un mecanismo que nos proporciona el lenguaje para evaluar condiciones que son true o false y así decidir que bloque de codigo se va a ejecutar.  

Para evaluar las condiciones con la sentencia if debemos aprender el concepto de operador condicional, este operador nos van a servir para evaluar condiciones, los operadores condicional son:  

```
> mayor que.
< menor que.
>= mayor o igual que.
<= menor o igual que
== igualdad.
!= desigualdad.  

```
OPERADORES LOGICOS

Con los operadores logicos podremos comparar mas de una condición.  

&& operador "y": con este operador todas las condiciones tienen que ser verdaderas para que se cumpla la sentencia if.  

|| operador "o": basta que se cumpla una de las condiciones para que se cumpla la sentencia if.  

! operador "no"

