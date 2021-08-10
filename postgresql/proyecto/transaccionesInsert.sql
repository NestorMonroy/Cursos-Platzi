BEGIN;

insert into estacion (nombre, direccion) values ('Transac', '4608 Wayridge Circle');
insert into tren (modelo, capacidad) values ('Transc 6000', 80);
/*
select * from estacion order by id desc;
select * from tren order by id desc;

ROLLBACK;
*/

select * from estacion order by id desc;
select * from tren order by id desc;

COMMIT;