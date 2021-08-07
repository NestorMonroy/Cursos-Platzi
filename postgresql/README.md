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