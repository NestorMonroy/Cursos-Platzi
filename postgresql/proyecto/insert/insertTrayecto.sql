INSERT INTO public.trayecto(
	id_estacion,id_tren, nombre)
	VALUES (1, 1, 'Ruta1');


SELECT * FROM trayecto;


INSERT INTO public.trayecto(
	id_estacion,id_tren, nombre)
	VALUES (23, 23, 'Ruta23');
	

/*
ERROR:  insert or update on table "trayecto" violates foreign key constraint "trayecto_estacion_fkey"
DETAIL:  Key (id_estacion)=(23) is not present in table "estacion".
SQL state: 23503
*/


INSERT INTO public.trayecto(
	id_estacion, id_tren,nombre)
	VALUES (1, 2, 'Ruta 2 ');
	