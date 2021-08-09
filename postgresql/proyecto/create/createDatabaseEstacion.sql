CREATE TABLE IF NOT EXISTS public.estacion
(
    id serial,
    nombre character varying,
    direccion character varying,
    CONSTRAINT estacion_pkey PRIMARY KEY (id)
);

ALTER TABLE public.estacion
    OWNER to postgres;