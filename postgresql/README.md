### ¿Qué es Postgresql?

El motor de bases datos (RDBMS) es quién estructura toda la información de la base de dato. 
El servidor es una computadora dónde se instala el motor de base de dato. 
La bases es la información ordenada, relacionada y estructurada a la cual accedemos con SQL

Buenas praticas

• A: Atomicity – Atomicidad -> Separar las funciones desarrolladas en la BD como pequeñas tareas y ejecutarlas como un todo. Si alguna tarea falla se hace un rollback(Se deshacen los cambios)
• C: Consistency – Consistencia -> Todo lo que se desarrolló en base al objeto relacional. Los datos tienen congruencia
• I: Isolation – Aislamiento -> Varias tareas ejecutándose al mismo tiempo dentro de la BD
• D: Durability – Durabilidad -> Puedes tener seguridad que la información no se perderá por un fallo catastrófico. PostgreSQL guarda la información en una Bitácora

### Install PostgreSQL and pgAdmin on Ubuntu 20.04

sudo apt-get update
lsb_release -a
sudo apt install postgresql

- Set root user credentials
sudo -u postgres psql
ALTER USER postgres PASSWORD 'Ejemplo*';
\q

Henceforth you can login to the PostgreSQL shell using the command
psql -U postgres -h localhost

\du


CREATE USER userEjemplo WITH SUPERUSER CREATEROLE CREATEDB LOGIN ENCRYPTED PASSWORD 'Ejemplo*';

--You should also create a database with the same name as the user. Create database using the command

CREATE DATABASE tableEjemplo;

\l

--You can grant access to existing databases to the user using the command

GRANT ALL PRIVILEGES ON DATABASE tableEjemplo TO userEjemplo;


pgAdmin4 

Create the repository configuration file:
curl https://www.pgadmin.org/static/packages_pgadmin_org.pub | sudo apt-key add

-- after
sudo sh -c 'echo "deb https://ftp.postgresql.org/pub/pgadmin/pgadmin4/apt/$(lsb_release -cs) pgadmin4 main" > /etc/apt/sources.list.d/pgadmin4.list && apt update'

--
To install desktop mode, use the command:

sudo apt install pgadmin4-desktop

To install web mode, use the command:

sudo apt install pgadmin4-web

To install both, use the command:

sudo apt install pgadmin4


To configure web mode, run the command:

sudo /usr/pgadmin4/bin/setup-web.sh


Comandos importantes:
Si quiero ver el listado de todos los comandos con \ escribo en consola de postgres: ?

* Ver los comandos de POSTGRES : \?
* Listar todas las bases de datos: \l
* Ver las tablas de una base de datos: \dt
* Cambiar a otra base de datos: \c nombre_DB
* describir una tabla: \d nombre_tabla
* Ver comandos SQL: \h
* Ver como se ejecuta un comando SQL: \h nombre_de_la_función
* Control + c: Cancela todo lo que hay en pantalla.
* Consultar versión de postgres instalada: SELECT version();
* Volver a ejecutar la función que acabaste de ejecutar en la consola: \g
* Inicializar el contador de tiempo para que la consola diga cuanto se demoro en ejecutar ese comando : \timing
* Control + L: Limpiar pantalla.

### Archivos de Configuración

A través de la sentencia SHOW CONFIG se nos muestra donde están los 
archivos de configuración. En mi caso la ruta es:
/Library/PostgreSQL/12/data/postgresql.conf
```sql
SHOW config_file;
```

Algo a tener en cuenta es que en la ruta por default de instalación no se puede acceder debido a falta de permisos. Para ingresar basta con un:

sudo cd /Library/PostgreSQL/12/data/

Postgresql.conf: Configuración general de postgres, múltiples opciones referentes a direcciones de conexión de entrada, memoria, cantidad de hilos de pocesamiento, replica, etc.

pg_hba.conf: Muestra los roles así como los tipos de acceso a la base de datos.

pg_ident.conf: Permite realizar el mapeo de usuarios. Permite definir roles a usuarios del sistema operativo donde se ejecuta postgres.


### Comandos mas usados

```sql
SELECT VERSION();
    PostgreSQL 11.6 (Ubuntu 11.6-1.pgdg18.04+1) on x86_64-pc-linux-gnu, compiled by gcc (Ubuntu 7.4.0-1ubuntu1~18.04.1) 7.4.0, 64-bit
\h -- ayuda
\h comando -- ayuda del comando especifico
\l -- Listar las bases
\c base de datos --moverse a una base de datos especifica
\dt -- listar las tablas de la base actual
\dn -- listar los esquemas de la base actual
\dv -- listar las vistas
\df -- listar las funciones
\du -- listar los usuarios
\g -- ejecutar ultimo comando 
\s -- historial de comandos
\l nombrearchivo --guardar lista de comandos
\i nombre archivo -- ejecuta comandos guardados
\e -- abrir editor 
\ef -- editor de funciones
\timming -- activar o desactivar el tiempo de respusta de las consultas
\q cerra consola
CREATE DATABASE base; -- crea base
CREATE TABLE tabla (columnas); crea tabla
INSERT INTO tabla(columna) VALUES('dato');
SELECT * FROM tabla;
UPDATE tabla SET cammpo = dato WHERE condicion;
DELETE FROM tabla WHERE condicion;
```

### Tipos de datos relevantes en PostgreSQL 


Tipos de datos

Principales:
* Numéricos(Numeros enteros, Numeros Decimales, Seriales)
* Monetarios(cantidad de moneda)
* Texto(almacenar cadenas y texto, existen tres VARCHAR, CHAR, TEXT)
* Binario(1 Y 0)
* Fecha/Hora(Para almacenar Fechas y/o Horas, DATE TYPE, TIME TYPE, TIMESTAMP, * INTERVAL)
* Boolean(Verdadero o Falso)
* Especiales propios de postgres
* Geométricos: Permiten calcular distancias y áreas usando dos valores X y Y.
* Direcciones de Red: Cálculos de máscara de red
* Texto tipo bit: Cálculos en otros sistemas, ejm(hexadecimal, binario)
* XML, JSON: Postgres no permite guardar en estos formatos
* Arreglos: Vectores y Matrices


https://www.ibiblio.org/pub/linux/docs/LuCaS/Tutoriales/NOTAS-CURSO-BBDD/notas-curso-BD/node134.html


### Diseñando nuestra base de datos: estructura de las tablas

<img width="70%"  src="./images/f0feaf7781e7.jpg"  />

### Jerarquía de Bases de Datos

Toda jerarquía de base de datos se basa en los siguientes elementos:

* Servidor de base de datos: Computador que tiene un motor de base de datos instalado y en ejecución.
* Motor de base de datos: Software que provee un conjunto de servicios encargados de administrar una base de datos.
* Base de datos: Grupo de datos que pertenecen a un mismo contexto.
* Esquemas de base de datos en PostgreSQL: Grupo de objetos de base de datos que guarda relación entre sí (tablas, funciones, relaciones, secuencias).
* Tablas de base de datos: Estructura que organiza los datos en filas y columnas formando una matriz.

PostgreSQL es un motor de base de datos.

La estructura de la base de datos diseñada para el reto corresponde a los siguientes
elementos:

<img width="70%"  src="./images/649e66cad472.jpg"  />


La base de datos se llama transporte, usaremos su esquema predeterminado public.

El esquema public contiene las siguientes tablas:

* Estación
* Pasajero
* Tren

Y las tablas de relaciones entre cada uno de los elementos anteriores son:

* Trayecto
* Viaje

El esquema relacional entre las tablas corresponde al siguiente diagrama:

<img width="70%"  src="./images/c11c5b76b9aa.jpg"  />


Estación
Contiene la información de las estaciones de nuestro sistema, incluye datos de nombre con tipo de dato texto y dirección con tipo de dato texto, junto con un número de identificación único por estación.

Tren
Almacena la información de los trenes de nuestro sistema, cada tren tiene un modelo con tipo de dato texto y una capacidad con tipo de dato numérico que representa la cantidad de personas que puede llevar ese tren, también tiene un ID único por tren.

Trayecto
Relaciona los trenes con las estaciones, simula ser las rutas que cada uno de los trenes pueden desarrollar entre las estaciones

Pasajero
Es la tabla que contiene la información de las personas que viajan en nuestro sistema de transporte masivo, sus columnas son nombre tipo de dato texto con el nombre completo de la persona, direccion_residencia con tipo de dato texto que indica dónde vive la persona, fecha_nacimiento tipo de dato texto y un ID único tipo de dato numérico para identificar a cada persona.

Viaje
Relaciona Trayecto con Pasajero ilustrando la dinámica entre los viajes que realizan las personas, los cuales parten de una estación y se hacen usando un tren.


### Particiones

Las particiones consisten en: 
1.Separación Física esto es guardar varias partes de la misma tabla en diferentes espacios de disco e incluso en otros discos; 
2.Conservar la Estructura Lógica esto es que se puede hacer el el SELECT de la misma forma como se hacía anteriormente.



### Creación de Roles

Que puede hacer un ROLE

* Crear y Eliminar
* Asignar atributos
* Agrupar con otros roles
* Roles predeterminados

```sql
-- Ver las funciones del comando CREATE ROLE (help)
\h CREATE ROLE;

-- Creamos un ROLE (consultas -> lectura, insertar, actualizar)
CREATE ROLE usuario_consulta;
CREATE USER usuario_consulta;
-- Mostrar todos los usuarios junto a sus atributos
\dg

-- Agregamos atributos al usuario o role
ALTER ROLE  usuario_consulta WITH LOGIN;
ALTER ROLE  usuario_consulta WITH SUPERUSER;
ALTER ROLE  usuario_consulta WITH PASSWORD '1234';
 
-- Elimanos el usuario o role
DROP ROLE usuario_consulta;

-- La mejor forma de crear un usuario o role por pgadmin
CREATE ROLE usuario_consulta WITH
  LOGIN
  NOSUPERUSER
  NOCREATEDB
  NOCREATEROLE
  INHERIT
  NOREPLICATION
  CONNECTION LIMIT -1
  PASSWORD'1234';

--Para obtorgar privilegios a nuestro usuario_consulta
GRANT INSERT, SELECT, UPDATE ON TABLE public.estacion TO usuario_consulta;
GRANT INSERT, SELECT, UPDATE ON TABLE public.pasajero TO usuario_consulta;
GRANT INSERT, SELECT, UPDATE ON TABLE public.trayecto TO usuario_consulta;
GRANT INSERT, SELECT, UPDATE ON TABLE public.tren TO usuario_consulta;
GRANT INSERT, SELECT, UPDATE ON TABLE public.viaje TO usuario_consulta;
```

Ubuntu 

psql -h localhost -d transporte -U usuario_consulta -p 5432