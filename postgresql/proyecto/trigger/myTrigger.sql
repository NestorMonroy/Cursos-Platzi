CREATE TRIGGER mitrigger
AFTER INSERT
ON pasajero
FOR EACH ROW
EXECUTE PROCEDURE impl();

INSERT INTO public.pasajero(
	nombre, direccion_residencia, fecha_nacimiento)
	VALUES ('Pasajero TRIGGER', 'XXX', '2021-08-09');
	

DROP TRIGGER mitrigger ON pasajero;