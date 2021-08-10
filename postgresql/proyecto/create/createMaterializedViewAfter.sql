CREATE MATERIALIZED VIEW public.despues_2020_mview
AS
SELECT * FROM viaje WHERE inicio > '2020-01-01' order by (inicio) asc
WITH NO DATA;

ALTER TABLE public.despues_2020_mview
    OWNER TO postgres;


REFRESH MATERIALIZED VIEW despues_2020_mview
