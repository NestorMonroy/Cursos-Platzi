
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