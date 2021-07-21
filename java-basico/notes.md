¿Que es JAVA?
- Java es un lenguaje de programación
- Java es un lenguaje de programación de alto nivel
- Es Multiplataforma (puede correrse en diferentes sistemas operativos)
- Java tiene dos categorías:
+ Standard Edition.- para construir aplicaciones de escritorio o consola
+ Enterprise Edition.- para que las empresas trabajen aplicaciones web de última generación
- Java sigue filosofía de Write Once, Run Anywhere (WORA), por lo que todo lo que aprendas en Java SE lo podrás aplicar también con Java EE

HISTORIA
- Fue creado en 1991 por James Gosling mientras trabajaba en Sun Microsystems
- Fue comprada por ORACLE en 2009


Versiones de Java y JDK.

El JDK o Java Development Kit se compone de:
• Java Runtime Environment (JRE): la máquina virtual de Java, es lo que ayuda a que sean programas multiplataformas.
• Compilador de Java: se encarga de traducir el código a algo que la maquina pueda entender.
• APIs de desarrollo: una base de código lista para ayudarnos a desarrollar.

JDK -> V 11 COBRO 

OpenJDK Es la version open-source de Java SE Platform Edition

Version 10 cambio en forma de declaracion de variables

Apache Maven -- desarrollo web 
gradle -- desarrollo web y servidor 
java spring


OpenJDK 8
sudo apt-get install openjdk-8-jre

OpenJDK 11
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt update
sudo apt install openjdk-11-jdk


java -version

Cambiar la version de java

sudo update-alternatives --config java

Install IntelliJ IDEA 

snap find "intellij"

sudo snap install intellij-idea-ultimate --classic

### Escribe tu primer Hola Mundo en Java

Los archivos de Java usan la extensión .java. Por lo tanto, para crear nuestro primer “Hola, mundo” podemos hacerlo desde un archivo HolaMundo.java.

El método main es el punto de entrada de una aplicación en diferentes lenguajes como Java, Kotlin y C++. Sin este método nuestra aplicación no se ejecutará y mostrará un error.

En Java definimos este método de la siguiente manera:

```java
public static void main (String[] args) {
  // acciones
}

```
Por lo tanto, este será el código de nuestro HolaMundo.java y podremos ejecutarlo con Click derecho > Run 'HolaMundo.main()':

```java
public class HolaMundo {
  public static void main (String[] args) {
    System.out.println("Hola, mundo!");
  }
}
```

Recuerda que nuestro IDE nos proporciona algunos atajos. Por ejemplo, con solo escribir la palabra sout podremos autocompletar la sentencia System.out.println();.

¡No olvides dejar todas tus dudas y comentarios en la sección de discusiones! Así podemos ayudarte a resolver todos tus inconvenientes.


### Etapas de la programación en Java

* Escribir nuestros archivos .java.
* Compilar, cargar y verificar nuestros archivos con javac (los IDEs nos permiten compilar con solo presionar un botón).
* Al compilar obtenemos archivos .class con código que nuestras computadoras pueden entender (Byte Code).
* La JVM (Java Virtual Machine) se encarga de ejecutar el código de forma que funcione en cualquier dispositivo o sistema operativo.
Java es un lenguaje compilado e interpretado al mismo tiempo.


### La JShell de Java

Sabías que Java tiene una herramienta interactiva en dónde puedes ir probando segmentos de código en vez de realizar todo el proceso de creación de un programa en Java. Escribir, compilar y correr.

Su nombre es jshell y está disponible desde la versión 9 de Java.

Abre tu consola de comandos o terminal, corre el siguiente comando:

```
$ java -version
```

Cambia la versión de Java desde tu consola de comandos o terminal y compártenos en la sección de discusiones los comandos que ejecutaste.

Asegurate de tener definida una versión superior a la 8.
Ahora desde tu terminal escribe el siguiente comando para abrir nuestra jshell

```
$ jshell

```

### Variables en Java

Una variable es un espacio de memoria (RAM) que contiene un dato de tipo numérico, booleano, de texto u otros tipos de datos un poco más complejos.

Las variables en Java se componen de un nombre único y un valor que puede cambiar a lo largo de la ejecución del programa. Al declarar las variables debemos definir el tipo de dato que vamos a usar y un punto y coma al final:

```java
// Variables.java

public class Variables {
  public static void main(String[] args) {
    // Declarar la variable speed de tipo int (números enteros)
    int spped;

    // Actualizar el contenido de la variable speed:
    spped = 10; // si ya habías declarado la variable

    // Declarar una variable y asignarle un valor al mismo tiempo:
    int salary = 1000;

    // Crear una variable de tipo String:
    String eployeeName = "Nestor Monroy";
  }
}

```
