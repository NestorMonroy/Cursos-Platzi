CREATE TABLE IF NOT EXISTS public.pasajero
(
    id serial,
    nombre character varying(200),
    direccion_residencia character varying,
    fecha_nacimiento date,
    CONSTRAINT pasajero_pkey PRIMARY KEY (id)
);

ALTER TABLE public.pasajero
    OWNER to postgres;
