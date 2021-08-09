CREATE TABLE IF NOT EXISTS public.tren
(
    id serial,
    modelo character varying,
    capacidad character varying,
    CONSTRAINT tren_pkey PRIMARY KEY (id)
);

ALTER TABLE public.tren
    OWNER to postgres;