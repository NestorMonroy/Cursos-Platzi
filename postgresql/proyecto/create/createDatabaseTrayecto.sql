CREATE TABLE IF NOT EXISTS public.trayecto
(
    id serial,
    id_tren integer,
    id_estacion integer,
    CONSTRAINT trayecto_pkey PRIMARY KEY (id),
    CONSTRAINT trayecto_tren_pkey FOREIGN KEY (id_tren)
        REFERENCES public.tren (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT trayecto_estacion_pkey FOREIGN KEY (id_estacion)
        REFERENCES public.estacion (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE public.trayecto
    OWNER to postgres;