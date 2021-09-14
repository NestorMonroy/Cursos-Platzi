## Clases del Curso de Fundamentos de Java Spring Boot

### ¿Qué es Spring Boot?

https://start.spring.io/

https://docs.spring.io/spring-boot/docs/2.0.x/reference/html/index.html

* Proyecto basado en Spring. No es lo mismo que Spring. Es un proyecto que forma parte del core de Spring, al igual que Spring Cloud, etc.
* El objetivo principal es que sólo te centres en correr la aplicación, sin preocuparte por temas de configuración, etc.
* Tiene la gran ventaja poder integrar librerías de terceros de manera muy sencilla.
* No tendremos que preocuparnos por configuraciones a nivel de XML, sólo configuraciones mínimas a nivel de properties (ponerle el puerto, etc).
* No tendremos que preocuparnos de desplegar nuestra aplicación en un servidor web local cuando queramos hacer pruebas, Spring Boot también contempla esto y lleva incorporado un servidor web dónde se desplegará nuestra aplicación automáticamente.




### Características principales de Spring Boot

* Independiente: no tenemos que preocuparnos de las dependencias del core de Spring ni de la compilación de estas.
* Incrustado Tomcat, Jetty o Undertow: Spring Boot trae consigo un servidor web como los tres mencionados donde podemos correr nuestra aplicación sin preocuparnos de generar un artefacto WAR o JAR y desplegarlo nosotros mismos.
* Proporción de dependencias: no debemos preocuparnos por las configuraciones de depndencias de terceros o del core de Spring, Spring Boot se encargará de inyectar todo lo necesario.
* Sin generación de XML: No debemos preocuparnos de configuración XML para que nuestra aplicación funcione.
* Métricas de salud del aplicativo: podemos validar el estado de un servicio desplegado, sus dependencias, estado de memoria, magnitud de configuración, etc.


### Qué es una dependencia?

Pequeña característica de un objeto especifico, que puede impactar de manera particular en el funcionamiento de una unidad.
Por ejemplo, las dependencias de un Smartphone serian:

* Cámara
* Micrófono
* Pantalla
* Batería

Alta cohesión: Involucra que la entidad ejecute sus acciones sin involucrar otra clase o entidad.

Bajo acoplamiento Hablamos de acoplamiento bajo cuando existe una independencia entre los componentes entre si, por el contrario un alto acoplamiento es cuando tenemos varias dependencias relacionadas a un solo componente.

Entonces podemos afirmar que en la definición de un buen diseño de software se debe tener una ALTA COHESIÓN y un BAJO ACOPLAMIENTO.

* Objetos definidos como una funcionalidad, sin la cual, los otros objetos no podrían trabajar, ya que dependen de ella. Por ejemplo, un volante es una dependencia de un vehículo, ya que sin volante, no podemos conducir el vehículo.
* Las dependencias nos permiten modularizar nuestra aplicación, lo cual nos beneficia en las pruebas unitarias.


### Inversión de control y el patrón de inyección de dependencias

Patrón que utiliza inversión de control para utilizar las dependencias inicializadas con el contenedor Spring.

Ventajas de IoC

* Desacoplamiento.
* Segregación de interfaces.
* Fácil testing.
* Mayor modularidad.


¿Qué es inyección de dependencias?

* La inyección de dependencias (DI) es el proceso con el que los objetos definen sus dependencias
* Codigo mas limpio y decoplamiento mas efectivo cuando cada objecto cuenta con su dependencia
* Implementacion del principio de inversion de control.
* Definicon de los otros objetos con los que trabajan.
* Clases mas faciles de probar, en particular cuando son interfaces.

Hay 3 formas de aplicar la inyeccion de dependencias:
-Por medio de atributo
-Por medio de metodos sets
-El mas famoso es por medio de constructor.


Qué es un bean? 

Un bean básicamente son módulos desarrollados en Spring estos seencargan de brindarnos toda la lógica que necesitamos para nuestra aplicación. Ejemplo: Si necesitamos referenciar que nuestra clase es un modelo hacemos uso de el bean @entity . Esto nos permite usar propiedades creadas para este tipo de modulo que nos agilizan nuestro desarrollo. Al hacer inversión de control nosotros al llamar esos beans lo que hacemos es referenciar módulos funcionales creados por spring. Spring boot nos facilita el fácil instanciamiento de estos a nuestra aplicación, haciendo todo por nosotros…


### AUTOCONFIGURACION Y RUNTIME

Configura automáticamente tus aplicaciones basadas en dependencias JAR que agregaste mediante el pom.xml, pero si nosotros realizamos una configuración manual esta es priorizada por Spring Boot.


### ¿QUE ES UNA ANOTACION EN SPRING BOOT?

Una Anotación es una forma de añadir metadatos al código fuente Java que están disponibles para la aplicación en tiempo de ejecución o de compilación. Es una alternativa mas sencilla al uso de XML.

TIPOS DE ANOTACIONES

@Controller: Para indicar que esta será la clase que gestionara las peticiones del usuario por get, post, put, patch o delete.

@Service: Con esta notación especificamos que en esta clase se encontrara toda nuestra lógica de negocio, cálculos o llamadas a otras API externas.

@Repository: Se usa para las clases o interfaces que funcionaran con el acceso a la base de datos.

Si nuestra clase o interfaz no tiene una especificación clara como @Service, @Repository o @Controller, simplemente recurrimos a @Component y le indicamos que sencillamente es un componente.

Por otro lado, no es estrictamente necesario que cumplas con colocar una notación especifica, pero es una buena practica.

-----------------
Se genera una interaz la cual vamos a implementar

```java
import java.util.List;

public interface MyOwnOperation {
    List<Integer> generateRandomElements(int maxElement, int maxLimit);
}
```

Se genera la implementacion de la intefaz generada

```java
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MyOwnOperationImplement implements MyOwnOperation{
    @Override
    public List<Integer> generateRandomElements(int maxElement, int maxLimit) {
        return new Random().ints(0, maxElement)
                .limit(maxLimit)
                .boxed() //Regresa un intStream
                .collect(Collectors.toList());
    }
}

```

Se genera una nuava intefaz

```java

public interface MyOwnBeanWithDependency {
    void displayElements();
}

```

Se genera nuevamente una implementacion

```java
import java.util.List;

public class MyOwnBeanWithDependencyImplement implements MyOwnBeanWithDependency{
    private MyOwnOperation myOwnOperation;

    //Constructor
    public MyOwnBeanWithDependencyImplement(MyOwnOperation myOwnOperation) {
        this.myOwnOperation = myOwnOperation;
    }

    @Override
    public void displayElements() {
        List<Integer> randomNums = this.myOwnOperation.generateRandomElements(100,10);
        randomNums.forEach(System.out::println);
        System.out.println("Hola desde mi implementación de un bean con dependencia usando Streams y Listas");
    }
}
```


En el archivo de configuracion de bean se agregan estas nuevas implementaciones

```java

@Bean
public MyOwnOperation beanOperationMyOwn() {
    return new MyOwnOperationImplement();
}

@Bean
public MyOwnBeanWithDependency beanOperationMyOwnWithDependency(MyOwnOperationmyOwnOperation){
    return new MyOwnBeanWithDependencyImplement(myOwnOperation);
}

```

Se realiza la inyecion de dependencias el main o donde lo ejecutaremos


```java

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
    //Inyección de dependencias con Spring
    private MyOwnBeanWithDependency myOwnBeanWithDependency;


    public FundamentosApplication(MyOwnBeanWithDependency myOwnBeanWithDependency) {
        this.myOwnBeanWithDependency = myOwnBeanWithDependency;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    //Método de la interfaz CommandLineRunner
    @Override
    public void run(String... args) throws Exception {
        //Lamamos a la implementación

        myOwnBeanWithDependency.displayElements();
    }
}
```


### Que son los logs


Los logs son una herramienta o utilidad que nos permite debugear la informacion

Apache Commos tiene algunos niveles de log

* Error
* Infor
* Debug
* otros


### Modelado de entidades con JPA

JPA 

Especificacion de Java para acceder, conservar y administrar datos entre objetos o clases y una base de datos relacional.

JPA
Java Persistence API

### JpaRepository

Registro a nivel de base de datos, metodos para insetar, obtener informacion .

### Uso de JPQL en anotacion Query

* JPQL es el lenjuaje de consulta definido por JPA
* Similar a SQL pero con la particularidad de operar sobre objectos

No se puede hacer insert en JPQL


### Que son los Query methods?

Es una definicion de una consulta manualmente como una cadena o derivarla del nombre del metodo.

### Named parameters

Son parámetros que se envían a nivel de sentencias, estos parámetros serán inicializados dentro los parámetros del método, representándolos por medio de la anotación @Param.


### Rollback con la anotación transactional

Al aplicar la anotación @transactional podemos presenciar al conjunto de operaciones ejecutándose de manera total, integral y atómica. Se sigue el acrónimo ACID (Atomicity, Consistency, Isolation and Durability: Atomicidad, Consistencia, Aislamiento y Durabilidad, en español).

---
¿Qué es JPA?
R= Es el enfoque estándar de la industria de Java para mapear objetos en bases de datos relacionales.

¿Cuál es el método para registrar una entidad en base de datos con JpaRepository?
R= save

¿Cuál es la anotación para indicar un archivo properties dentro de nuestro classpath?
R= PropertySource

¿Para qué sirve la anotación Service?
R= Se utiliza para representar la capa de servicios o lógica de negocio de nuestra aplicación.

¿Cuál propiedad nos permite cambiar el path del aplicativo?
R= server.servlet.context-path

¿La autoconfiguración en tiempo de ejecución es invasiva?
R= Falso

¿Cuál de los siguientes contenedores web de servlet NO permite Spring Boot?
R= Wildfly

¿Qué hace el siguiente queryMethod "findByEmailOrName"?
R= Encuentra una entidad a partir del email o el name.

¿Qué es JPQL?
R= Es un lenguaje de consulta de persistencia de datos.

¿Qué hace la siguiente propiedad? spring.jpa.show-sql=true
R= Habilita los logs para mostrar los SQL.

¿Qué es Spring Boot?
R= Es un proyecto basado en Spring cuyo objetivo principal es correr la aplicación.

¿Cuál de estas es una definición correcta de dependencia?
R= Es una funcionalidad de un programa que a su vez hace parte de otra funcionalidad para lograr un objetivo.

En versiones recientes de Spring Boot ¿es necesario utilizar la anotación autowired?
R= Falso

¿Cuál es la interfaz que permite implementar el método para hacer paginación en Spring Boot?
R= PagingAndSortingRepository

¿Para qué sirve la anotación transactional?
R= Para hacer rollback de los registros en base de datos en caso de que ocurra un error en la implementación.

Es una ventaja del principio de inversión de control:
R= Facilita el testing por componentes o mocks de dependencias.

Una de estas NO es una ventaja de IoC (inversión de control):
R = Implementa el patrón de inyección de dependencias.

¿Para qué sirve la anotación @value?
R = Para representar valores a nivel de properties.

¿Qué es inversión de control?
R = Es un principio de desarrollo de software que permite transferir el control de objetos de un programa a un contenedor o framework.

¿Qué hace el siguiente código? @Value("${driver}") private String myDriver;
R= Captura el valor de la propiedad driver y la representa en la variable myDriver.

¿Cuál de estos es un objetivo principal de Spring Boot?
R = Que al desarrollar no nos centramos en términos de configuración, sino en términos de ejecución.

¿Qué es un bean?
R= Es un objeto que es administrado, instanciado y ensamblado por el contenedor de Spring.