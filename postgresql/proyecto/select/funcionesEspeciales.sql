INSERT INTO public.estacion(
	id, nombre, direccion)
	VALUES (1, 'Nombre', 'Dire')
	ON CONFLICT(id) DO UPDATE SET nombre = 'Nombre', direccion='Dire';
	
	
INSERT INTO public.estacion(
	nombre, direccion)
	VALUES ('RET', 'RETUR')
RETURNING*;

SELECT * FROM pasajero where nombre LIKE 'o%';
SELECT * FROM pasajero where nombre ILIKE 'o%';
-- % _

SELECT * FROM tren WHERE modelo IS NULL;
SELECT * FROM tren WHERE modelo IS NOT NULL;


SELECT id, COALESCE(nombre, 'No aplica') nombre, direccion_residencia FROM pasajero WHERE id = 1;

SELECT NULLIF(0,0);
SELECT GREATEST(0,5,9,7,1);
SELECT LEAST(0,5,9,7,1);


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

