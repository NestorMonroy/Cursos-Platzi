CREATE OR REPLACE VIEW public.rango_view
 AS
SELECT id, nombre, fecha_nacimiento,
	CASE
	WHEN ( current_date - fecha_nacimiento) > 6570 Then 'Es mayor de 18 años'
	ELSE 'Es un niño'
	END
FROM pasajero ORDER BY fecha_nacimiento;
;

ALTER TABLE public.rango_view
    OWNER TO postgres;


select * from rango_view