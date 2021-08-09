CREATE TABLE IF NOT EXISTS public.bitacora_viaje
(
    id serial,
    id_viaje integer,
    fecha date
) PARTITION BY RANGE (fecha);

ALTER TABLE public.bitacora_viaje
    OWNER to postgres;