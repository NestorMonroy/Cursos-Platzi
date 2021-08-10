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