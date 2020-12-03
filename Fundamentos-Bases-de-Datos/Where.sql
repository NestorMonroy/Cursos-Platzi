-- WHERE examples
SELECT *
FROM posts
WHERE id < 50;

SELECT *
FROM posts
WHERE estatus != 'activo';

SELECT *
FROM posts
WHERE titulo LIKE '%mundo%';

SELECT *
FROM posts
WHERE fecha_publicacion > '2030-01-01';

SELECT *
FROM posts
WHERE fecha_publicacion BETWEEN '2020-01-01' AND '2023-12-31';

SELECT *
FROM posts
WHERE YEAR(fecha_publicacion) BETWEEN '2023' AND '2024';

SELECT *
FROM posts
WHERE MONTH(fecha_publicacion) = '04';

SELECT *
FROM posts
WHERE usuario_id IS NOT NULL
AND estatus = 'activo';

SELECT *
FROM posts
WHERE usuario_id IS NULL;