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

public class UpdatingVariables {
    public static void main(String[] args) {
        int salary = 1000;
        //Salario total
        //bono $200
        salary = salary + 200;
        System.out.println(salary);

        //pension $50 pesos
        salary = salary - 50; // operaciones matematicas para alterar sus datos
        System.out.println(salary);

        //2 horas extra $30
        //Comida: $45

        salary = salary + (30*2) - 45;
        System.out.println(salary);
        
        //Actualizando cadenas de texto
        String employeeName  = "Nestor Monroy";
        employeeName = employeeName + " Valero"; //concatenar un valor +
        System.out.println(employeeName);

        employeeName = "David " + employeeName;
        System.out.println("Tu nombre es " + employeeName);
    }
}


```



### Convención de Nombres en Java

Una convención de nombres es un patrón que deben seguir los nombres de las variables para que el código esté organizado, entendible y sin repetidos.

* Java es sensible a mayúsculas y minúsculas, este punto es clave al seguir una convención.
* Las variables siempre deben comenzar con un simbolo de letra, $ o _.
* No puedes usar el simbolo - en ninguna parte de la variable.

Las variables constantes son variables cuyo valor nunca va a cambiar, por lo que se deben escribir completamente en mayúsculas y usando el caracter _.

```java

public class NamingJava {
    public static void main(String[] args) {
        int celphone = 33333;
        int celPhone = 777;
        System.out.println(celphone);
        System.out.println(celPhone);

        String $countryName = "Mexico";
        String _backgroundColor = "Blue";

        String currency$ = "MXN";
        String background_color = "PINK";

        //Las constantes son Mayusculas
        int POSITION = -5;
        int MAX_WIDTH= 9999;
        int MIN_WIDTH = 1;

    }
}

```


### Técnica de Naming: Camel Case

Camel Case es una convención muy popular para nombrar nuestras variables. Podemos usarlo en modo Upper Camel Case o Lower Camel Case, la diferencia es si comenzamos el nombre de la variable con mayúscula o minúscula.

```java
// Upper Camel Case:
class SoyUnaClase {};

// Lower Camel Case
int soyUnNumeroInt = 10;

```

Debemos usar Upper Camel Case en los nombres de las clases y archivos. Y Lower Camel Case en los nombres de las variables o métodos.


### Tipos de datos numéricos

Tipos de datos para números enteros (sin decimales):

* byte: Ocupa 1 byte de memoria y su rango es de -128 hasta 127.
* short: Ocupa 2 bytes de memoria y su rango es de -32,768 hasta 32,727.
* int: Ocupa 4 bytes de memoria y su rango es de -2,147,483,648 hasta 2,147,483,647. Es muy cómodo de usar, ya que no es tan pequeño para que no quepan nuestros números ni tan grande como para desperdiciar mucha memoria. Puede almacenar hasta 10 dígitos.
* long: Ocupa 8 bytes de memoria y su rango es de -9,223,372,036,854,775,808 hasta 9,223,372,036,854,775,807. Para diferenciarlo de un tipo de dato long debemos terminar el número con la letra L.

Por ejemplo:

```java
// Int:
int n = 1234567890;

// Long:
long nL = 123456789012345L;

```

Tipos de datos para números flotantes (con decimales):

* float: Ocupan 4 bytes de memoria y su rango es de 1.40129846432481707e-45 hasta 3.40282346638528860e+38. Así como long, debemos colocar una letra F al final.
* double: Ocupan 8 bytes de memoria y su rango es de 4.94065645841246544e-324d hasta 1.79769313486231570e+308d.

Por ejemplo:

```java
// Double:
double nD = 123.456123456;

// Float
float nF = 123.456F;
```


### Tipos de datos char y boolean

* char: Ocupa 2 bytes y solo puede almacenar 1 dígito, debemos usar comillas simples en vez de comillas dobles.
* boolean: Son un tipo de dato lógico, solo aceptan los valores true y false. También ocupa 2 bytes y almacena únicamente 1 dígito.

Seguro te diste cuenta que siempre debemos escribir el tipo de dato de nuestras variables antes de definir su nombre y valor. Pero esto cambia a partir de Java 10: solo debemos escribir la palabra reservada var y Java definirá el tipo de dato de nuestras variables automáticamente:

```java
var salary = 1000; // INT
var pension = salary * 0.03; // DOUBLE
var totalSalary = salary - pension; // DOUBLE

```

Recuerda que esto solo funciona con versiones superiores a Java 10.