### Conociendo algunas bases de datos relacionales: MySQL, PostgreSQL, Oracle

Oracle: licenciada versión gratuita
SQL Server: servidor o en la nube
Mysql: Open Source
2009: Sun microsystems
2009: maria db (mysql pero open source)
Postgressql
SqLite: DB liviana, utilizada en móviles

problememas con conectar al servidor
sudo apachectl stop


### Creando nuestra base de datos usando DDL

```sql
create table mensajes_app.mensajes(
ID_MENSAJE INT(7) AUTO_INCREMENT,
MENSAJE VARCHAR(280) NOT NULL,
AUTOR_MENSAJE VARCHAR(50) NOT NULL,
FECHA_MENSAJE timestamp NOT NULL,
PRIMARY KEY(ID_MENSAJE)
);
```

### JDBC

Java Data Base Connectivity
Clases

* DriverManager: es para cargar un driver (según el motor de BD). Nos permite crear una instancia de la conexión.
* Connection: para establecer conexiones con las bases de datos**.** Genera la sesión, maneja todo el ciclo de vida de una sesión cuando nos conectamos a una base de datos.
* Statement: para ejecutar sentencias SQL y enviarlas a las BD. Nos ayuda a traer datos de una tabla.
* PreparedStatement: hace lo mismo que Statement sólo que permite recibir parámetros (clausula where).
* ResultSet: para almacenar el resultado de la consulta y almacenarlos en nuestros objetos (modelos). Es una interfaz que nos ayudará a manejar los datos obtenidos convirtiendo los datos en objetos.



### Instalar dependencias en IntelliJ IDEA.

Abrir el archivo pom.xml en el editor
Presionar Alt + Insert
Buscar la dependencia a agregar, en este caso mysql-connector-java

Elegir la dependencia y la versión que se desea agregar, y dar click en Ok

Conexion
```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    public Connection get_connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "");
            if (connection != null) {
                System.out.println("Conexion existosa");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
}

```

Inicio
```java
import java.sql.Connection;

public class Inicio {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        try(Connection cnx = conexion.get_connection()) {

        }catch (Exception e){
            System.out.println(e);
        }
    }
}

```



--------------

¿Para qué sirve el método POST?
R= Para enviar información.

¿Qué tipo de respuesta ofrece la API de Twitter?
R= Una respuesta en formato JSON.

¿Cuáles son los tipos de persistencias para datos informáticos?
R= En Archivos y Bases de datos.

¿Para qué sirve el método DELETE?
R= Para eliminar información.

¿Cuál es la jerarquia en una base de datos relacional?
R= Base de datos > Tabla > Columna.

¿Qué debe tener una llave primaria para que no se envíe en la inserción de datos?
R= Autoincrement

¿Qué ocurre si no aplicamos un WHERE en un DELETE?
R= Borraremos todos los registros de una tabla.

¿Cómo se puede autenticar un usuario en una API?
R= Mediante un token.

¿Cuál es el comando SQL para actualizar datos?
R= update

¿Cuál de las siguientes es una base de datos relacional?
R= PostgreSQL

¿Qué significa DDL?
R= Lenguaje de definición de datos.

¿Cuál de los siguientes es un conector válido de Java con una base de datos MySQL?
R= jdbc

¿Qué IDEs podemos usar para desarrollar en Java?
R= Cualquiera que tenga soporte para Java.

¿Cuál es el comando SQL para eliminar datos?
R= delete

¿Cuál de los siguientes métodos HTTP permite traer datos?
R= get

¿Cuál es el comando SQL para insertar datos?
R= insert into

¿Cuál de las siguientes es una base de datos NoSQL?
R= MongoDB

¿Cuál es el método HTTP más usado en las APIs públicas?
R= GET

¿Qué métodos HTTP permiten actualizar datos?
R= PUT y Patch

¿Qué significa MER?
R= Modelo entidad relación.

¿Cuál es el formato estándar para las APIs Rest?
R= JSON

¿Qué es Maven?
R= Un asistente para tareas de compilación y generación de proyectos en Java.

¿Para qué sirve la clausula WHERE?
R= Para filtrar los datos de acuerdo a una condición.

¿En qué sistemas operativos podemos instalar mysql-server?
R= Windows, Linux y Mac.

¿Cuál es el comando SQL para leer datos?
R= select

¿Qué significa API?
R= Application Programming Interface.

¿Cuál de los siguientes NO es un método HTTP?
R= Insert

¿Cuál es la principal diferencia entre bases de datos relacionales y no relacionales?
R = La estructura en la que guardan la información.

¿Cuáles son las operaciones básicas para trabajar con una entidad, tabla o grupo de datos?
R = Crear, Listar, Actualizar y Borrar.

¿Cómo sabe la base de datos que debe actualizar un registro y no varios?
R = por la llave primaria
