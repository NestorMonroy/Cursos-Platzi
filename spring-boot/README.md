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

