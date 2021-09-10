### ¿Qué es y qué usaremos de Spring?

Spring es el framework más usado de Java. Nos ofrece herramientas que nos permite crear proyectos más avanzados, con mejores prácticas y en menor tiempo. También posee una gran comunidad, lo que nos brinda muchísima documentación y ayuda.

Spring tiene una estructura modular y flexible, lo que nos hace usar solo lo que necesitemos.

Vamos a usar 4 subproyectos de Sping:

* Spring Framework: Permite crear aplicaciones empresariales. Es transversal, ya que todos lo usan.
* Spring Boot: Con el que podemos crear aplicaciones autocontenidas y autoconfigurables.
* Spring Data: Gestionar e integrar bases de datos.
* Spring Security: Gestionar la seguridad de la aplicación.

### Conocer qué es una aplicación autocontenida

Las arquitecturas modernas se basan de acuerdo a una aplicacion autocontenida
Cada aplicación internamente contiene su servidor de aplicaciones con su configuración totalmente independiente una de la otra en lugar de todas las aplicaciones centralizadas en un solo servidor

Spring Boot

* Es el proyecto de Spring para aplicaciones autocontenidas
* Olvidarnos de la infraestructura y centrarnos en el desarrollo
* Puede funcionar con Tomcat (por defecto), Jetty o Undertow.
*  Incluye gestión de dependencias iniciales, configuración automática y más

<img src>
<img with="20%" src="./static/images/spring1-41d.jpg" />


### Qué es Spring Initializr?

https://start.spring.io/

* Sitio oficial para generar un proyecto de Spring Boot
* En poco tiempo y a nuestra medida
* Con todo lo que necesitamos para empezar

Project:

Los projectos Maven gestionan las dependencias conarchivos XML
Los archivos Gradle son escritos en Groovy y permite crear tareas que se pueden ejecutar al momento de hacer despliegue o integración continua

Utilizar la version estable de spring boot y llenar los metadatos
* Spring Web: permite genera APIs rest utilizando Apache Tomcat como servidor por defecto
* build.gradle: Es donde etsta escrita toda la configuración del proyecto (plugins, version de Java, dependencias, software para pruebas etc.)
* Carpeta gradle: Archivos necesarios para que gradle funcione
* @SpringBootApplication: indica la clase que gestiona la aplicación
