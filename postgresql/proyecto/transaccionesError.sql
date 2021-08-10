BEGIN;

INSERT INTO tren (modelo, capacidad) VALUE ('Transc 6000', 80);

INSERT INTO estacion (id, nombre, direccion) VALUE (103, 'Transac PENDIENTE', '4608 Wayridge Circle');

/*
select * from estacion order by id desc;
select * from tren order by id desc;

ROLLBACK;
*/

COMMIT;

select * from tren order by id desc;