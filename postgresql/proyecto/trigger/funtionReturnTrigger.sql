--select impl();
--select * from cont_pasajero;
--DROP FUNCTION impl();

--DROP TRIGGER mitrigger ON pasajero;

CREATE OR REPLACE FUNCTION impl(
	)
    RETURNS TRIGGER
    LANGUAGE 'plpgsql'
AS $BODY$
DECLARE
	rec record;
	contador integer :=0;
	
BEGIN
	FOR rec IN SELECT * FROM pasajero LOOP
		contador := contador + 1;
	END LOOP;
	INSERT INTO cont_pasajero(total, tiempo)
	VALUES(contador, now());
	--RETURN OLD puede acceder al id. 
	RETURN NEW; --Return update
END
$BODY$;
