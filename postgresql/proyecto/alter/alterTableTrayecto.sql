ALTER TABLE public.trayecto DROP CONSTRAINT trayecto_estacion_pkey;

ALTER TABLE public.trayecto DROP CONSTRAINT trayecto_tren_pkey;

ALTER TABLE public.trayecto
    ADD CONSTRAINT trayecto_estacion_fkey FOREIGN KEY (id_estacion)
    REFERENCES public.estacion (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
    NOT VALID;

ALTER TABLE public.trayecto
    ADD CONSTRAINT trayecto_tren_fkey FOREIGN KEY (id_tren)
    REFERENCES public.tren (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
    NOT VALID;


ALTER TABLE public.trayecto
    ADD COLUMN nombre character varying;

ALTER TABLE public.trayecto
    ALTER COLUMN nombre TYPE character varying(100) COLLATE pg_catalog."default";