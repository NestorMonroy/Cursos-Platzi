--CREATE EXTENSION dblink;

SELECT * FROM pasajero
JOIN 
dblink ('dbname=remota
		port=5432
		host=127.0.0.1
		user=usuario_consulta
		password=1234',
		'SELECT id, fecha FROM vip') as datos_remotos(id integer, fecha time without time zone)

--ON (pasajero.id = datos_remotos.id);
USING (id);

