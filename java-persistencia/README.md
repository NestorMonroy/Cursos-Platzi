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



