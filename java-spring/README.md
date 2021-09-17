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

### ¿Qué es JPA?

Jpa es una especificación de Java, standar, para un framework ORM. Quiere decir que son uan serie de reglas que Java define para que cualquier framework que quierea interactura con la BD de Java, tenga que seguir.

Los frameworks mas populares de Java para este fin son:

* Hibernate
* TopLink
* EclipseLink
* ObjectDB

JPA utiliza anotaciones para conectar clases a tablas de la BD y asi evitar hacerlo de manera nativa con SQL.

* @Entity. Indica a una clase de java que esta representando una tabla de nuestra BD.
* @Table. Recibe el nombre de la tabla a la cual esta mapeando la clase.
* @column. Se le pone a los atributos de la clase, no es obligatoria, se indica sólo cuando el nombre de la columna es diferente al nombre del atributo de la tabla.
* @id amd @EmbededID. Es el atributo como clave primaria de la tabla dentro de la clase. @id se utiliza cuando es clave primaria sencilla y @EmbededID cuando es una clave primaria compuesta.
* @GeneratedValue. Permite generar automáticamente generar valores para las clases primarias en nuestras tablas en las clases
* @OneToMany and @MatyToOne. Representar relaciones como existen en las tablas, en las clases

### Spring Data


Spring Data NO es una implementacion de JPA, sino mas bien es un proyecto que usa JPA para ofrecer funcionalidaes extra en la gestion de tareas desde JAVA a las base de datos.

Spring Data internamente tiene varios subproyectos, entre ellos: Spring Data JPA y Spring Data JDBC, para conectarnos a BD relacionales (SQL). Spring Data MongoDB y Spring Data Cassandra, son proyectos para conectarnos a BD no relacionales.

La tarea principal de Spring Data es optimizar tareas repitivas.

Spring data nos provee de respositorios sin codigo, nos permiten hacer todo tipo de operaciones en BD (CRUD) sin utilizar una linea de código.

También nos provee de auditorías transparentes, por ello, posee un motor de auditorias que nos permite saber cuadno se insertó un registro, cuando se borró, cuando se actualizo en la BD, etc.

#### Implementación en el proyecto Market

Se busca en MAVEN el repositorio Spring Boot Starter Data JPA, se copia el group y el name en las dependencias del archivo build.gradle de nuestro proyecto quedando de la siguiente manera.

```java
dependencies {
    //Dependencia agregada
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	
    implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation('org.springframework.boot:spring-boot-starter-test') {
		exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
	}
}
```


###

Cuando se tiene una tabla en la que su llave primara es compuesta, se debe hacer una clase aparte que contenga los atributos que conforman la llave

Creando la Clase que tendra nuestra llave compuesta
Recuerda que debe de contener lo siguiente:

* se le debe agregar la anotacion @Embeddable
* se debe de hacer un “implements Serializable”
* debe contener los atributos que conformen la llame compuesta
* como en la mayoria de entidades debemos crear los getter y setters


En la clase principal debemos tener:

* Declarar la variable id como el tipo de la clase que creamos de nuestra llave compuesta que en este caso es : “ComprasProductoPK”
* Agregarle la etiqueta @EmbeddeId que hace referencia a que es una llave compuesta y que esta dada por otra clase
* Y nuevamente los Getter y Setters

### Spring Data Repositories


Tres tipos de repositorios:

* CrudRepository: realizar el crue
* PagingAndSortingRepository: incluye lo de Crud repository ademas de paginación y ordenamiento.
* JPARepository: Ademas de tener CrudRepository y PagingAndSortingRepository nos permite tareas específicas como Flush.


### Query Methods

Los query method son muy potentes. Además de los explicado, permiten realizar múltiples operaciones de comparación con:

* Números: mayores, menores, iguales…
* Textos: contiene cierta porción de texto, empieza o termina con una porción de texto, ignora case sensitive…
* Fechas: Antes de cierta fecha, después de cierta fecha, entre cierta fecha…
* Joins entre entidades: Si tenemos una entidad que se relaciona con otra, es posible realizar “joins” con esa relación para tener queries más específicas según nuestra necesidad. Por ejemplo, si tengo una relación de Producto y Categoría y quiero tener todos los productos de cierta categoría podría hacer: findAllByCategoriasId(Integer categoriaId) y así poder llegar a esta relación. Esto puede mezclarse con múltiples relaciones en simultáneo
* Comparación entre un conjunto de datos: Si por ejemplo quiero traerme los productos con varias categorías, podría escribir findAllByCategoriasIdIn(List<Integer> categoriaIds); y así trabajar bajo un conjunto de Id de categorías

Existen más funcionalidades ✌🏼. Pueden ver más detalle acá: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation


### Implementar la anotación @Repository

@Repository: le indicamos a la clase que es la encarga de interactuar con la base de datos.
@Component: le indicamos que es un componente de spring.

El primero es mejor porque indicamos el tipo de componente que es.

### ¿Qué es el patrón Data Mapper y qué resuelve?

DataMappers - Mapeando los datos

Nos permite desacoplar la persistencia de la aplicación. Consiste en convertir o traducir varios objetos que pueden cumplir la misma labor. De esta forma podemos:

* Independizar la base de datos de la API, desacoplanto la capa de persistencia o de negocio.
* Desacoplarnos de una base de datos puntua, así no tendríamos que refactorizar todo el código si la capa de persistencia cambia.
* Evitar campos innecesarios en la API.
* Evitar mezclar idiomas en la aplicación.

### MapStruct

Mapear los entity a las objetos de dominio (Hacer el traductor entre la capa de la persistencia y la capa de dominio=

https://stackoverflow.com/questions/48521903/map-custom-method-mapper-to-mapstruct

### Inyección de dependencias

Inyección de dependencias: pasar la dependencia a la clase que lo va a utilizar en lugar de crearla internamente dentro esa clase. Esto con el fin de no acoplar la clase a la implementación que esta utilizando.
Inversión de control: es un framework quien toma control de los objetos. En este caso Spring. El cual se encarga de crear y administrar instancias de objetos que se conocen como builds o componentes.
Entonces Spring usa la notación @Autowired para la inyección de dependencias.


Solid

* Single responsability
* Open-closed
* Liskov sustitution
* Interface segregation
* Dependency injection


### Implementar la anotación @Service

Las implementaciones del método delete son buenos ejemplos de los estilos declarativo e imperativo.
El primero define el qué va a hacer el código mientras que el segundo define el cómo y por consiguiente se ven más detalles. Cabe aclarar que el estilo declarativo no puede existir sin el estilo imperativo ya que el primero se apoya en el segundo para ocultar las estructuras de control (if, else, switch, etc).


### 
#### Paso 1 Crear el dominio de compras
Dentro de el packete dominio crear
Purchase.java

```java
package com.nestor.market.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {
    private int purchaseId;
    private String clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<PurchaseItem> item;

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PurchaseItem> getItem() {
        return item;
    }

    public void setItem(List<PurchaseItem> item) {
        this.item = item;
    }
}
```

y PurchaseItem.java

```java

public class PurchaseItem {
    private int productId;
    private int quantity;
    private double total;
    private boolean active;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
```

#### Paso 2 Mapear el dominio de compras

Dentro del packete persistance.mapper crear

PurchaseItemMapper.java
```java

import com.nestor.market.domain.PurchaseItem;
import com.nestor.market.persistance.entity.ComprasProducto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProducto", target = "productId"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active")
    })
    PurchaseItem toPurchaseItem(ComprasProducto producto);

    @InheritInverseConfiguration
		//Se 
    @Mappings({
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true),
            @Mapping(target = "id.idCompra", ignore = true)
    })
    ComprasProducto toComprasProducto(PurchaseItem item);
}

```

Generar igual el mapper PurchaseMapper.java

```java
import com.nestor.market.domain.Purchase;
import com.nestor.market.persistance.entity.Compra;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productos", target = "items")
    })
    Purchase toPurchase(Compra compra);

    List<Purchase> toPurchases(List<Compra> compras);


    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compra toCompra(Purchase purchase);
}
```

#### Paso 3 Crear el repositorio de compras

Dentro de persistence, agregamos CompraRepository.java
```java
package com.nestor.market.persistance;

import com.nestor.market.domain.Purchase;
import com.nestor.market.domain.repository.PurchaseRepository;
import com.nestor.market.persistance.crud.CompraCrudRepository;
import com.nestor.market.persistance.entity.Compra;
import com.nestor.market.persistance.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;


    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}

```

Igual necesitamos una interfaz que este ligada a este repositorio ** Dentro de persistence/crud

creamos CompraCrudRepository.java

```java
import com.nestor.market.persistance.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {
    Optional<List<Compra>> findByIdCliente(String idCliente);
}

```

Dentro del Entity de compra, 

```java

@Entity
@Table(name = "compra")
public class Compra {

    @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL}) //Todos los procesos que se hagan en la base de datos de una compra, se hara en cascada un producto
    private List<ComprasProducto> productos;

}
```

Dentro de Entity  ComprasProducto

```java


@Entity
@Table(name = "compras_productos")
public class ComprasProducto {


    @ManyToOne
    @MapsId("idCompra") // Cuando compras ID se guarde en cascada, se va a saber ha que llave primaria pertenece
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Compra compra;


}
```

#### Paso 4, se generan los servicios

Se crea una clase dentro de service PurchaseService.java

```java
package com.nestor.market.domain.service;

import com.nestor.market.domain.Purchase;
import com.nestor.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseRepository.getByClient(clientId);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
```

Se crea otra clase, la cual realiza el controlador del servico. Dentro de web controler se crea 
PurchaseController.java


```java
package com.nestor.market.web.controller;

import com.nestor.market.domain.Purchase;
import com.nestor.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public ResponseEntity<List<Purchase>> getAll() {
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{idClient}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient") String clientId) {
        return purchaseService.getByClient(clientId).map(
                purchases -> new ResponseEntity<>(purchases, HttpStatus.OK)
        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
```



### Documentar nuestra API con Swagger

https://mvnrepository.com/artifact/io.springfox/springfox-swagger2

swagger, se debe tener en cuenta lo siguiente:

En el archivo bundle.gradle se debe añadir las siguientes líneas
implementation "io.springfox:springfox-boot-starter:3.0.0"
compile “io.springfox:springfox-swagger-ui:3.0.0”

En la clase SwaggerConfig ya no hace falta añadir la anotación @EnableSwagger2
La url de acceso a la documentación es: {host}:{puerto} / {contexto} /swagger-ui/index.html

Se instalan las dependencias en  build.gradle

```

dependencies {
	implementation 'io.springfox:springfox-swagger2:2.9.2' // swagger
	implementation 'io.springfox:springfox-swagger-ui:2.9.2' // swagger
}
```

Se agrega un nuevo paquete dentro de web llamado config, posterios se crea la clase SwaggerConfig.java

```java

package com.nestor.market.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.nestor.market.web.controller"))
                .build();
    }
}
```

http://localhost:8090/market/api/swagger-ui.html

Dentro de los controladores **  se agregan anotaciones

```java

@RestController //Controlador de una API REST
@RequestMapping("/products")
public class ProductController {



    @GetMapping("/all")
    @ApiOperation("Get all supermarket products")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product with an ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Product not found"),
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of the product", required = true, example = "7")
                                                  @PathVariable("id") int productId) {
        return productService.getProduct(productId)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



}
```

http://localhost:8090/market/api/swagger-ui.html#/product-controller


### Configurar la seguridad de nuestra API con Spring Security

https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security

* Autenticacion y autorizacion para aplicaciones de Spring
* Como todos los proyectos de Spring, es muy facil de configurar
* Proteccion ante ataques como Session Fixatioon, clickjacking, cross site request forget, entre otros
* Configuracion por defecto 


Se instalan las dependencias en  build.gradle

```

dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-security'
}
```

### Que es JWT

* Estandar de codigo abierto basado en JSON para crear tokens de seguridad

* La autenticacion viaja en el header de la peticion: Authorization: Bearer <token>
