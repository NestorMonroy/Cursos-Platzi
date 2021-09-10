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

### Configurar Spring Boot

Propiedades de la aplicación

application.properties, application.yml o línea de comando 
○ (configurar un nuevo numero de puerto)

Posibilidad de añadir propiedades propias
```
server.port=8090
server.servlet.context-path=/market/api
localhost:8090/market/api/saludar/hola
```
Gestión de perfiles según el tipo de despliegue
(se puede utilizar para desplegar perfiles para dev y para prod)

* Ser gestionado para varios entornos
* Es muy importante seguir el patron den nombramiento

application.properties
	spring.profiles.active=dev
	server.servlet.context-path=/win-market/api
application-dev.properties
	server.port=8090
application-pdn.properties
	server.port=80

Common Application properties

https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html


### Crear la estructura del proyecto

La estructura del proyecto será de la siguiente manera:

1. DOMINIO:

* DTO y objetos del dominio (Contexto de la aplicación)
* Servicios: Puente entre los controladores y la capa de persistencia.
* Especificación de repositorios: Interfaces que determinan las reglas que debe cumplir la persistencia para actuar entre los objetos de dominio y la DB.

2. WEB:

* Controladores de API Rest.

3. PERSISTENCIA:

* Repositorios: Implementan las especificaciones que tiene la capa de DOMINIO.
* Entities: Mapean y actúan como tablas de la DB.

/market/src/main/java/com/nestor/market

mkdir -p domain/{dto,repository,service} persistance/{entity,crud} web/controller