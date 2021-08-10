--DROP FUNCTION impl();

CREATE OR REPLACE FUNCTION impl(
	)
    RETURNS integer
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE PARALLEL UNSAFE
AS $BODY$
DECLARE
	rec record;
	contador integer :=0;
	
BEGIN
	FOR rec IN SELECT * FROM pasajero LOOP
		RAISE NOTICE 'Un pasajero se llama %', rec.nombre;
		contador := contador + 1;
	END LOOP;
	INSERT INTO cont_pasajero(total, tiempo)
	VALUES(contador, now());
	RETURN contador;
	
END
$BODY$;

