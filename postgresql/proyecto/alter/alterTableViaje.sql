ALTER TABLE public.viaje DROP CONSTRAINT viaje_pasajero_pkey;

ALTER TABLE public.viaje DROP CONSTRAINT viaje_trayecto_pkey;

ALTER TABLE public.viaje
    ADD CONSTRAINT viaje_pasajero_fkey FOREIGN KEY (id_pasajero)
    REFERENCES public.pasajero (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
    NOT VALID;

ALTER TABLE public.viaje
    ADD CONSTRAINT viaje_trayecto_fkey FOREIGN KEY (id_trayecto)
    REFERENCES public.trayecto (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
    NOT VALID;