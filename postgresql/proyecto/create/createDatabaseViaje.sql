CREATE TABLE IF NOT EXISTS public.viaje
(
    id serial,
    id_pasajero integer,
    id_trayecto integer,
    incio date,
    fin date,
    CONSTRAINT viaje_pkey PRIMARY KEY (id),
    CONSTRAINT viaje_pasajero_pkey FOREIGN KEY (id_pasajero)
        REFERENCES public.pasajero (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID,
    CONSTRAINT viaje_trayecto_pkey FOREIGN KEY (id_trayecto)
        REFERENCES public.trayecto (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
);

ALTER TABLE public.viaje
    OWNER to postgres;