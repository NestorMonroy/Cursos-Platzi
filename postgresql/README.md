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

select current_date;
select current_time;

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

### Llaves foráneas

* Consistencia
* Estructura
* Tabla origen
* Tabla destino
* Acciones

```sql
-- Agregamos llave foranea de id_estacion a la tabla trayecto
ALTER TABLE public.trayecto
    ADD CONSTRAINT trayecto_estacion_fkey FOREIGN KEY (id_estacion)
    REFERENCES public.estacion (id) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE CASCADE
    NOT VALID;

-- Agregamos llave foranea de id_tren a la tabla trayecto
ALTER TABLE public.trayecto
    ADD CONSTRAINT trayecto_tren_fkey FOREIGN KEY (id_tren)
    REFERENCES public.tren (id) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE CASCADE
    NOT VALID;

-- Agregamos llave foranea de id_trayecto a la tabla viaje
ALTER TABLE public.viaje
    ADD CONSTRAINT viaje_trayecto_fkey FOREIGN KEY (id_trayecto)
    REFERENCES public.trayecto (id) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE CASCADE
    NOT VALID;

-- Agregamos llave foranea de id_pasajero a la tabla viaje
ALTER TABLE public.viaje
    ADD CONSTRAINT viaje_pasajero_fkey FOREIGN KEY (id_pasajero)
    REFERENCES public.pasajero (id) MATCH SIMPLE
    ON UPDATE CASCADE
    ON DELETE CASCADE
    NOT VALID;

-- Para borrar una llave foranea por si tienes algun error
ALTER TABLE public.viaje DROP CONSTRAINT viaje_trayecto_fkey;
```

### Inserción y consulta de datos

```sql
-- Agregando datos a la tabla estacion
INSERT INTO public.estacion (nombre, direccion)
VALUES ('Estacion Centro', 'St 1#12');

-- comprobamos los datos de la tabla estacion
SELECT * FROM public.estacion;

-- Agregando datos a la tabla tren
INSERT INTO public.tren (capacidad, modelo)
VALUES (100, 'Modelo 1');

-- comprobamos los datos de la tabla tren
SELECT * FROM public.tren;

-- Para eliminar y despues agregar la columna de nombre a la tabla trayecto
ALTER TABLE public.trayecto DROP COLUMN nombre;
ALTER TABLE public.trayecto ADD nombre character varying(100);

-- Agregando datos a la tabla trayecto
INSERT INTO public.trayecto (id_estacion, id_tren, nombre)
VALUES (1, 1, 'Ruta 1');

-- Comprobamos los datos de la tabla trayecto
SELECT * FROM public.trayecto;

-- Eliminar una tubla de la tabla tren con el id = 1, como esta en cascada se elimino la tuplas que tenian ese id_tren
DELETE FROM public.tren WHERE id = 1;

-- Cambiar la tupla que tenda el id = de la tabla tren
UPDATE public.tren SET id = 1 WHERE id = 2;
```


### Inserción masiva de datos

https://mockaroo.com/

Los que quieren limpiar las tablas:
```sql
TRUNCATE estacion  CASCADE;
TRUNCATE tren  CASCADE;
TRUNCATE trayecto  CASCADE;
TRUNCATE pasajero  CASCADE;
TRUNCATE viaje  CASCADE;
```

Comenzar el serial desde cero
```sql
TRUNCATE TABLE tren, trayecto, viaje, estacion, pasajero RESTART IDENTITY;
```

### Cruzar tablas: SQL JOIN


<img width="70%"  src="./images/sqljoin.jpeg"  />

```sql
--------------------------RESUMEN----------------------------------------
/* Inner join: solo nos trae los datos que coinciden en ambas tablas. */
select * from route r
inner join train tr
on tr.train_id = r.train_id;

/* Este es un full outer join: trae todos los datos de ambas tablas. Coincidan o no. */
select * 
from route r
full outer join train tr
on tr.train_id = r.train_id;


/*Este full outer join ahora solo nos trae los datos que no coinciden de la tabla A 
 con la la tabla B, tambien nos trae los datos de la tabla B que no coiniden con la
 tabla A. (es como el opuesto del inner join, porque en lugar de traernos los que 
 coinciden en ambas tablas, nos trae solo los que no coinciden en ambas tablas.)*/
select * 
from route r
full outer join train tr
on tr.train_id = r.train_id
where r.train_id is null
or tr.train_id is null;


/* left join: nos trae todos los datos de la tabla A(izquierda) y solo los datos de la
 tabla B que coincidan en la tabla A. */
select * from route r
left join train tr
on tr.train_id = r.train_id;

/* left outer join: nos devuelve todos los datos de la tabla A que no coincide con la
tabla B. */
select * from route r
left join train tr
on tr.train_id = r.train_id
where tr.train_id is null;

/*right join: nos devuelve todos los datos de la tabla B, y solo los datos de la tabla
A que coincidan con la tabla B*/
select * from route r
right join train tr
on tr.train_id = r.train_id;

/* right outer join: nos trae todos los datos de la tabla B que no coinciden con
la tabla A*/

select * from route r
right join train tr
on tr.train_id = r.train_id
where r.train_id is null;

/*NOTA: Cuando usamos left join (Tabla A a la tabla B) estamos usando la tabla A, es
decir traemos todos los datos de la tabla A y solo los datos de la tabla B que coinciden
con la tabla A. si queremos usar un left outer join la llave primaria null que debemos
especificar es la de la tabla B.
WHERE b.pkey us null;
lo mismo pasa cuando usamos un right outer join
como usamos la tabla B y solo los que coinciden con la tabla A entonces la llave null
que usamos es de la tabla A.
WHERE a.pkey us null;								*/
```


###  Funciones especiales

* ON CONFLICT DO => Solucionar problemas para insercion de datos ,  permite insertar si lo que queremos hacer es una actualización sobre el mismo dato. 
* RETURNING => Nos permite devolver todos los cambios que hemos hecho sobre la base de datos *(deshacer los cambios)
* LIKE / ILIKE  => Búsquedas al estilo de expresiones regulares, 
* IS / IS NOT => Nos permite comparar dos tipo de datos que no sean estandar como numerico * objecto => null o no lo es

```sql
-- Insercion de un dato que ya existe, no pasa nada
INSERT INTO public.estacion(id, nombre, direccion)
VALUES (1, 'Nombre', 'Dire')
ON CONFLICT DO NOTHING;

-- Insercion de un dato que ya existe, te cambia los campos de nombre y direccion
INSERT INTO public.estacion(id, nombre, direccion)
VALUES (1, 'Nombre', 'Dire')
ON CONFLICT (id) DO UPDATE SET nombre = 'Nombre', direccion = 'Dire';

-- Insertara una tupla y mostrara la tupla
INSERT INTO public.estacion(nombre, direccion)
VALUES ('RETU', 'RETDIRE')
RETURNING *;

-- %: Uno o cualquier valor
-- _: Un valor
SELECT nombre FROM public.pasajero
WHERE nombre LIKE 'o%';
-- buscamos sin importar mayusculas o minusculas
SELECT nombre FROM public.pasajero
WHERE nombre ILIKE 'o%';

-- si una estacion o tren tiene un valor nulo
SELECT * FROM public.tren
WHERE modelo IS NULL;
```

### Funciones Especiales avanzadas en PosgreSQL

• COALESCE: compara dos valores y retorna el que es nulo
• NULLIF: Retorna null si son iguales
• GREATEST: Compara un arreglo y retorna el mayor
• LEAST: Compara un arreglo de valores y retorna el menor
• BLOQUES ANONIMOS: Ingresa condicionales dentro de una consulta de BD

```sql

SELECT id, COALESCE(nombre, 'No aplica') nombre, direccion_residencia FROM pasajero WHERE id = 1;

SELECT id, nombre, direccion_residencia, fecha_nacimiento, 
CASE WHEN fecha_nacimiento > '2015-01-01' THEN 
'Nino' 
ELSE 
'Mayor' 
END
FROM pasajero;


SELECT id, nombre, fecha_nacimiento,
	CASE
	WHEN nombre ILIKE 'a%' THEN 'Comienza con A' 
	WHEN nombre ILIKE 'e%' THEN 'Comienza con E'
	WHEN nombre ILIKE 'i%' THEN 'Comienza con I'
	WHEN ( current_date - fecha_nacimiento) > 6570 Then 'Es mayor de 18 años'
	ELSE 'Su nombre no inicia con A, E o I y ademas es un niño'
	END
FROM pasajero ORDER BY fecha_nacimiento;


```

### Vistas


Agarra una consulta que se realice muchas veces y colocarla bajo un solo nombre.
Centraliza muchos esfuerzos en una sola función.

Vista volátil: Siempre que se haga la consulta en la vista, la BD hace la ejecución de la consulta en la BD, por lo que siempre se va a tener información reciente.

Vista materializada: Hace la consulta una sola vez, y la información queda almacenada en memoria, la siguiente vez que se consulte, trae el dato almacenado, eso es bueno y malo a la vez, bueno porque la velocidad con la que se entrega la información es rápida, malo porque la información no es actualizada. Es ideal utilizar este tipo de vista en procesos que utilice días anteriores, porque el día de ayer, ya pasó y no hay razón para actualizarlo.
Para crear una vista volátil en postgres, damos click derecho a views, create, view, le damos un nombre, y en la pestaña code escribimos o pegamos el código de la consulta que queremos guardar, la guardamos y para usar la vista usamos:
```sql
    SELECT * FROM <nombre_vista>; y listo.
```
Para crear una vista materializada, primero creamos la consulta, y definimos si los datos nos interesan o no, luego, vamos a la opción materialized views, click derecho, create, materialized view. Se abre la ventana, le damos un nombre, termina con _mview, y en la pestaña Definition escribimos la consulta que necesitamos guardar. Guardamos.
Al probarla en este momento nos lanza un error, ¿por qué? porque no tiene datos almacenados. Para almacenar datos usamos:
```sql
    REFRESH MATERIALIZED VIEW <nombre vista>;
--   Y ahora si podemos consultarla:

    SELECT * FROM <nombre_vista_mview>;

```

### PL/SQL

Las funciones y los Stored procedure son un pilar dentro de las bases de datos con ayuda de los lenguajes procedurales como PLPGSQL y PL/SQL (En el caso de Oracle). Gran parte de la lógica de negocios puede ser abstraída directamente en la base de datos con ayuda de dicho lenguaje permitiendo liberar al backend de parte de este procesamiento



    PL Procedural language, también conocido como procedimientos almacenados, estas nos ayuda a desarrollar código directamente en el motor de bases de datos.

    Estructura de un Pl es: Declaración + uso de variable+ código +fin + retorno de valores o no retorna valores.UN bloque de código se ejecuta con la palabra DO $$ BEGIN --insert código here END $$

    RAISE NOTICE ‘message’, esta sentencia es para enviar un mensaje en el log de postgres

    Retornar una tabla
    Retornar una tabla.

DO$$ -Declaración de un bloque de código SQL
Estructura

DO $BODY$ 
    BEGIN 
        --insert código here 
    END 
$BODY$

Ejemplo de declaración de bloques de código con plpgsql
```sql
DO $$ 
    DECLARE
        rec record;
        contador integer :=0;
    BEGIN 
        --recorre  tabla pasajero y lo guarda en la variable rec
        FOR rec IN SELECT * FROM pasajero LOOP 
            RAISE NOTICE 'id: %     ,Nombre: %      ',
                        rec.id,rec.nombre;
            contador := contador + 1;
        END LOOP;
        RAISE NOTICE 'cantidad de registros:    %', contador;
    END 
$$

CREATE FUNTION - Declaración de una función SQL

CREATE FUNCTION  consulta_usuarios() 
    RETURNS void
    LANGUAGE 'plpgsql';
AS $BODY$ 
    DECLARE
        rec record;
        contador integer :=0;
    BEGIN 
        --recorre  tabla pasajero y lo guarda en la variable rec
        FOR rec IN SELECT * FROM pasajero LOOP 
            RAISE NOTICE 'id: %     ,Nombre: %      ',
                        rec.id,rec.nombre;
            contador := contador + 1;
        END LOOP;
        RAISE NOTICE 'cantidad de registros:    %', contador;
    END 
$BODY$
```
OTRO Ejemplo:
Retornar una tabla con plpgsql ¡¡¡¡importante!!! es importante cual select uses para llamar la función. la función funciona de la siguiente manera en el parámetro sí se introduce NULL retorna toda la lista, si se introduce id retornará esa tupla

```sql
--FUNCION QUE RETORNA UNA TABLA
--Mostrar tabla con plpgsql
--https://stackoverflow.com/questions/18084936/pl-pgsql-functions-how-to-return-a-normal-table-with-multiple-columns-using-an
DROP FUNCTION consulta_t_pasajero(p_pasajero_id integer);

CREATE OR REPLACE FUNCTION consulta_t_pasajero(p_pasajero_id integer) 
RETURNS TABLE(id integer, nombre character varying, direccion_residencia character varying, fecha_nacimiento date) 
LANGUAGE plpgsql
AS $BODY$
    BEGIN
		IF p_pasajero_id IS NULL THEN 
		 RETURN QUERY 
			SELECT pasajero.id, pasajero.nombre, pasajero.direccion_residencia, pasajero.fecha_nacimiento
			FROM public.pasajero;
		END IF;
		RETURN QUERY 
			SELECT pasajero.id, pasajero.nombre, pasajero.direccion_residencia, pasajero.fecha_nacimiento
			FROM public.pasajero
			WHERE pasajero.id = p_pasajero_id;
    END;
$BODY$

--Retorno en forma de fila
SELECT consulta_t_pasajero(NULL); 
SELECT consulta_t_pasajero(50);
--Retorno en forma de tabla
SELECT * FROM consulta_t_pasajero(NULL);
SELECT * FROM consulta_t_pasajero(50);
```

### Triggers

Para la creación de triggers se debe hacer los siguiente
Crear la función que activará el evento. Para ello se debe tomar los siguientes aspectos:

* En la declaración de la función, en la sección del retorno se debe indicar que es tipo triggers es decir RETURNS TRIGGER.
    Luego indicar en que lenguaje está escrito es decir LANGUAE ‘plpgsql’
* La función tipo triggers debe retornar los valores OLD acepta lo viejo o NEW acepta lo nuevo. Sí se retorna VOID en nuestra función de tipo triggers no aceptamos cambios es decir RETURN NEW;
* Tanto NEW como OLD son un objeto de tipo record y contiene dentro de si el registro, es decir se puede acceder a los campos NEW.campo_nombre del registro

```sql
DROP FUNCTION IF EXISTS  count_on_insert_pasajero() CASCADE;

CREATE OR REPLACE FUNCTION count_on_insert_pasajero()
	RETURNS TRIGGER
	LANGUAGE 'plpgsql'
AS $BODY$
	DECLARE 
		contador integer:=0;
		rec record;
	BEGIN
		
		FOR rec IN SELECT * FROM pasajero LOOP 
			contador := contador + 1;
		END LOOP;
		RAISE NOTICE 'cantidad de registros:	%', contador;
		
		--insert record on conteo_pasajero
		INSERT INTO public.conteo_pasajero (total_pasajero,hora_conteo)
		VALUES (contador,now());
		
		RETURN NEW;
		
	END;	
$BODY$
```
Lo siguiente será crear la regla que estará a la escucha del evento para disparar el triggers, para ello se deberá tomar los siguientes aspectos.

* CREATE TRIGGER name_trigger name_event ON name_table FOR EACH ROW EXECUTE PROCEDURE name_procedure;
* En la primera sección cuando declaramos el trigger debemos indicar en que momento en que se debe disparar el trigger:
    * CREATE TRIGGER name_trigger name_event ON name_table en el name_event allí puede ir alguno de estos tres parámetros para llamar la ejecución del trigger, estos son:
   * BEFORE = antes,
   * AFTER=luego,
   * INSTEAD OF = hacer esto, en vez de lo que iba a hacer el motor de bases de datos.
   * FOR EACH ROW EXECUTE PROCEDURE name_procedure indica que es para registro o fila de nuestra tabla

```sql
-- CREACIÓN DE LA REGLA PARA EJECUTAR EL TRIGGER
CREATE TRIGGER trigger_on_insert_to_pasajero
AFTER INSERT ON pasajero 
FOR EACH ROW EXECUTE PROCEDURE count_on_insert_pasajero(); 
```

### Simulando una conexión a Bases de Datos remotas

https://mockaroo.com/

Simulando una conexión a Bases de Datos remotas

Obtener datos de hosts remotos

dblink

Primero debe verificarse que dblink esta instalado ya que es una extension de postgres y no viene por defecto

Crear la extension dblink que postgres incluye pero no instala por defecto, esta extension debe crearse por cada base de datos individual
```sql
CREATE EXTENSION dblink;


-- se deberian dejar espacio despues de cada instruccion ya que  son comandos diferentes
SELECT * FROM
dblink('dbname=remota 
  port=5432 
  host=127.0.0.1 
  user=xxxx 
  password=xxxx',
  'SELECT id, fecha FROM vip;')
  AS datos_remotos(id integer, "date" date);

--A la query se le debe dar el formato de como llegaran los datos

--Haciendo cruce de datos con una tabla local

SELECT * FROM passenger
JOIN 
dblink('dbname=remota 
  port=5432 
  host=127.0.0.1 
  user=xxxx 
  password=xxxxxxx',
'SELECT id, date FROM vip;')
AS datos_remotos(id integer, "date" date)
ON (passenger.id = datos_remotos.id);

--Ya que ambas tablas se cruzan por la columna id, el JOIN se puede hacer con USING(id)

SELECT * FROM passenger
JOIN 
dblink('dbname=remota 
  port=5432 
  host=127.0.0.1 
  user=xxxx 
  password=xxxxxxx',
'SELECT id, date FROM vip;')
AS datos_remotos(id integer, "date" date)
USING(id);

```

Al usar usign id el query retorna solo una columna de id en lugar de ambas columnas lo cual haria si se usara un ON para realizar el JOIN
Reto

query a la tabla de pasageros desde la tabla remota

```sql
-- CREATE EXTENSION dblink;
SELECT * FROM vip
JOIN 
dblink('dbname=transporte 
  port=5432 
  host=127.0.0.1 
  user=xxxxxxx 
  password=xxxxxxxxxxxx',
'SELECT id, name, address, birthdate FROM passenger;')
AS remote_passenger(id INTEGER, name CHARACTER VARYING, address CHARACTER VARYING, birthdate DATE)
USING(id);
```

### Transacciones
25.Transacciones
Las transacciones, tienen la capacidad para empaquetar varios pasos en una sola operación “todo o nada”.y si ocurre alguna falla que impida que se complete la transacción, entonces ninguno de los pasos se ejecuta y no se afecta la base de datos en absoluto.

SQL Transacción - Estructura
La transacciones tienen la siguiente estructura postgres. Postgres en las operaciones normales usa de manera implícita el rollback el rollback.
```
BEGIN;
<Intrucciones>
COMMIT|ROLLBACK
```
SQL Transacción - Ejemplo en PgAdmin

* Desactivamos en la equina superior de pg-admin el auto commit
* Iniciamos la transacción
```sql
BEGIN;
INSERT INTO  public.estacion(nombre,direccion)
VALUES('Estación Transacción',' 1');
 
INSERT INTO  public.tren(modelo,capacidad)
VALUES('Modelo Transacción','2');
 
COMMIT;
```
SQL Transacción - Ejemplo de un rollback implícito
Como se puede visualizar en el ejemplo existe una inserción correcta en la tabla tren pero en la tabla estación sé está haciendo un insert a un id que existe realmente.
```sql
BEGIN;
 
 
INSERT INTO  public.tren(modelo,capacidad)
VALUES('Modelo Transacción 2','2');
 
INSERT INTO  public.estacion(id,nombre,direccion)
VALUES(101,'Estación Transacción 2',' 1');
 
COMMIT;

```

### Otras Extensiones para Postgres
https://www.postgresql.org/docs/11/contrib.html


```sql
CREATE EXTENSION fuzzystrmatch;
--Cantidad de letras que cambian 
SELECT levenshtein ('nestor', 'nextor');
--Algoritmos de Matching-Learning- / aproximacion de palabras 0 - 4  donde 4 es muy similar
SELECT difference  ('nestor', 'nextor');

SELECT difference  ('beard', 'bird');

```


### Backups y Restauración

pg_dump: genera todos los archivos de configuración para hacer una copia de nuestra BD.


Custom, Esta opción única de postgres y solo se puede restaurar por pgAdmin. 
Tar, Es un archivo comprimido que contiene la estructura de la base de datos. Plain, simplemente es un archivo.sql. Directory tiene solo la estructura sin comprimir de la base de datos.

Compression ratio: es el número de veces que algoritmo de compresión se ejecuta para reducir el tamaño del archivo

Encoding: hace referencia al tipo de codificación de los carácteres

```sql
pg_dump --file "/home/copia" --host "127.0.0.1" --port "5432" --username "postgres" --no-password --verbose --format=c --blobs "transporte"

pg_restore --host "127.0.0.1" --port "5432" --username "postgres" --no-password --dbname "nueva" --verbose "/home/copia"
```


### Mantenimiento

Postgres maneja una serie de funciones que trabajan en segundo plano mientras que trabajamos directamente en la base de datos, y esto es a lo que le llamamos mantenimiento.

El nombre más común de esto es Vaccum, ya que esto quita todas las filas y columnas e items del disco duro que no están funcionando, ya que postgres al percatarse de esto, las marca como “para borrar después”.
Tiene 2 niveles de limpieza.
Liviano, se ejecuta todo el tiempo en la DB en segundo plano.
Full o completo, que es capaz de bloquear las tablas para hacer la limpieza y luego la desbloquea.
Full es importante porque puede que una tabla tenga problemas de indexación y se demore mucho en hacer las consultas.
Hacer mantenimiento en DB no es lo mismo que hacerlo directamente en las tablas.
Para ejecutar el mantenimiento se da clic derecho sobre la DB o la tabla, y luego a la opción “Maintenance”.
En tablas, aparecen 3 opciones
full: Revisa toda la información de la tabla, si hay información que no es aplicable limpiará/eliminará la fila con la información del índice y demás. Activar o desactivar full puede tumbar totalmente la DB.
freeze: durante el proceso se va a congelar. Ningún usuario va a tener acceso a esta tabla hasta que no termine el proceso de limpieza.
analyze: El más suave, el programa ejecutará una revisión y mostrará qué tan bien o mal está la tabla.
Es importante siempre hacer el mantenimiento en el horario en donde menos es utilizada la DB, ¿por qué? porque si hay menos tráfico los usuarios no van a sentir tanto la ausencia del servicio. Igualmente, en la medida de las posibilidades se puede usar una DB de respaldo para que el servicio no se vea ofuscado durante el mantenimiento, luego, una vez hecho el mantenimiento se puede actualizar la DB con los datos generados en la DB de respaldo.




* Vacuum: La más importante, con tres opciones, Vacuum, Freeze y Analyze.
* Full: la tabla quedará limpia en su totalidad
* Freeze: durante el proceso la tabla se congela y no permite modificaciones hasta que no termina la limpieza
* Analyze: solo revisa la tabla
* Analyze: No hace cambios en la tabla. Solo hace una revisión y la muestra.
* Reindex: Aplica para tablas con numerosos registros con indices, como por ejemplo las llaves primarias.
* Cluster: Especificamos al motor de base de datos que reorganice la información en el disco.

### Introducción a Réplicas

Son mecánismos que permiten evitar problemas de entrada y salida en los SO.
“Existen 2 tipos de personas, los que ya usan réplicas y los que las van a usar…” 

- Piensa siempre en modo réplica.

A medida que la DB crece encontraremos limitaciones físicas y de electrónica, si la DB aumenta tanto su tamaño, las limitaciones serán de procesamiento, RAM, almacenamiento.

Hemos visto que las consultas en local son muy rápidas, sin embargo, cuando la aplicación ha sido desplegada pueden ocurrir multiples peticiones de lectura y escritura. Todos los motores de DB pueden hacer una ejecución a la vez, por lo que recibir tantas peticiones de consulta al mismo tiempo puede hacer que regresar una consulta se demore demasiado y eso puede ser catastrófico, pero las réplicas son la solución a este tipo de problemas.
¿Cuál es la estrategia? Tener una base de datos principal donde se realizan todas las modificaciones, y una base de datos secundaria dónde se realiza las lecturas. Separar las tareas es altamente beneficioso en cuanto al rendimiento de la aplicación, así, cuando se modifica una DB automáticamente se lleva el cambio a la DB de lectura. Todo lo que hay que hacer es configurar 2 servidores de postgres, uno como maestro y otro como esclavo. Se debe modificar la aplicación para que todas las modificaciones se hagan sobre el maestro y la lectura sobre la replica, o la DB en caliente. Es imposible realizar cambios en la DB de réplica.


### Implementación de Réplicas en Postgres

Las replicas consisten en tener multiples servidores de Postgresql con un minimo de un Master y una Replica

para lograrlo se deben realizar hacer cambios en las configuraciones de la base de datos Master

en postgresql.conf
```conf
# los archivos de bitacora se comporten como hot standby
# es decir mantiene los archivos hasta que las replicas los utilizen
wal_level = hot_standby

# Este valor corresponde a la cantidad de replicas que vamos a tener
max_wal_senders = 2

# Como trataremos los archivos de bitacora, los archivaremos para que los puedan leer lar replicas
archive_mode = on

# Se especifica un comando de linux para copiar los archivos y dejarlos en una carpeta temporal 

archive_command = 'cp %p /tmp/%f'
# tambien en el archivo pg_hba.conf en la base de datos Master se debe agregar la ip de la base de datos para replicacion

local   all         all                               md5
host    all         all         127.0.0.1/32          ident
host    all         all         ::1/128               ident
host    all         all         0.0.0.0/0             md5
host    replication all         xxxxxxxxxx/32         trust -- La direccion de la replica 

```
Reiniciar el servicio -- 

Ahora para la base de datos de Replica nos conectamos por SSH


```
# Detenemos el servicio
--sudo service postgresql stop

# Borramos los datos locales

rm -rf /var/lib/pgsql/data/*

# Traemos todos los datos de master y los traemos a replica
# $host_de_master_db -> ip de master 
# $puerto_de_la_master_db -> puerto de master

pg_basebackup -U $user_de_master -R -D /var/lib/pgsql/data/ --host=$host_de_master_db --port=$puerto_de_la_master_db

# Modificamos el archivo postgresql.conf de replica

# esto define postgres como una base de datos de replica
hot_standby = on

#Ahora que los cambios estan hechos reiniciamos el servicio
sudo service postgresql start

```

A partir de ahora las configuraciones se han guardado y ya funcionan en modo de master y replica

incluso la contraseña del servicio replica ahora sera la misma del servicio master

a partir de ahora todos los cambios hechos en master se recrean en replica, y cualquier cambio hecho en replica no se ejecutara ya que estara en modo de solo lectura.

--------------------
¿Cuál de los siguientes tipos de datos permite texto?
R= Character Varying

Es importante crear ROLES y dejar de usar el predeterminado de Postgres porque:
R= Permite crear una estructura de permisos a la medida.

Con PgAdmin sólo puedes modificar la estructura de base de datos de manera visual, no hay editor de código.
R= Falso

La principal limitación de rendimiento que tenemos en bases de datos es:
R= Los IOPS

¿Cuál es el comando que nos muestra la lista de todos los comandos tipo backslash disponibles en la consola?
R= \?

La principal diferencia entre Vistas y Vistas Materializadas es:
R= Las Vistas no almacena los datos en disco. Las Vistas Materializadas sí.

¿Qué es Postgresql?
R= Un motor de base de datos.

Podemos usar DBLINK en medio de una consulta
R= Verdadero

La creación de llaves primarias y llaves foráneas en una tabla sólo se puede hacer con el comando CREATE TABLE.
R= Falso

¿Es posible actualizar la información en una réplica?
R= Falso

La relación entre objetos tangibles normalmente se traduce en:
R= Una tabla relacional.

¿Cuáles son los 3 archivos principales de configuración de PostgreSQL?
R= postgresql.conf, pg_hba.conf y pg_ident.conf.

Para alivianar los IOPS de la base de datos podemos:
R= Todas son correctas.

Dos comandos de cierre para una transacción son:
R= COMMIT y ROLLBACK

El tipo de dato SERIAL sirve para:
R= Crear valores consecutivos para una columna.

¿Cuál comando nos sirve para activar la medición de tiempo de las consultas en la consola?
R= \timing

La única forma de insertar datos en una tabla usando un generador de datos aleatoreos es:
R= No existe una única forma.

¿Los TRIGGERS pueden ser usados para ignorar inserts?
R= Sí. Se usa con BEFORE y RETURN NULL.

Las extensiones nos permiten:
R= Extender la funcionalidad de PostgreSQL.

Vacuum Full es peligroso porque:
R= Bloquea las tablas durante el proceso.

ON CONFLICT DO nos permite:
R = Decidir qué hacer en caso de conflicto al insertar valores en una tabla.

En la teoría de conjuntos, el INNER JOIN corresponde a:
R = Intersección

Un forma de representar relaciones entre tablas es por medio de:
R = Llaves foráneas.

¿En qué consiste la creación de particiones de una tabla en Postgresql?
R = Dividir lo que es lógicamente una tabla grande en piezas físicas más pequeñas.

¿Cuál versión de PostgreSQL es recomentable instalar?
R = Revisar la fecha y no descargar la última versión si es muy reciente.

¿Cuáles dos acciones podemos capturar de una tabla maestra usando llaves foráneas?
R = Al borrar y actualizar.

¿En una PL/PgSQL se puede ejecutar código tanto SQL cómo no SQL?
R = Sí. Siempre y cuando el lenguaje indicado sea plpgsql.

¿Es posible usar bloques condicionales de tipo IF en una consulta de PostgreSQL?
R =Sí. Usando CASE WHEN.
-------

Las replicas funcionan usando:
R MAL= Copias de seguridad.
R MAL = Roles de replicación.
R MAL = DBLINK

¿Qué formato debes usar si queremos ver la consulta equivalente a nuestra base de datos al momento de hacer Backup?
R MAL= Custom
R MAL = Tar
R MAL = DBLINK