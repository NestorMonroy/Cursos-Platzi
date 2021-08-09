/*Se crea la particion ya que hara referencia a la fecha de insersion*/
CREATE TABLE bitacora_viaje201001 PARTITION OF bitacora_viaje 
FOR VALUES FROM ('2010-01-01') TO ('2010-01-31');


INSERT INTO public.bitacora_viaje(
	 id_viaje, fecha)
	VALUES (1, '2050-02-10');

/*
ERROR:  no partition of relation "bitacora_viaje" found for row
DETAIL:  Partition key of the failing row contains (fecha) = (2050-02-10).
SQL state: 23514

*/

INSERT INTO public.bitacora_viaje(
	 id_viaje, fecha)
	VALUES (1, '2010-01-10');

/*
INSERT 0 1
*/