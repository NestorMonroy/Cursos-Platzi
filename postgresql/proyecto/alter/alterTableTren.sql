ALTER TABLE public.tren DROP COLUMN capacidad;

ALTER TABLE public.tren
    ADD COLUMN capacidad integer;