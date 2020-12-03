-- FROM
SELECT titulo as encabezado, fecha_publicacion as publicado_en, estatus as estado
FROM posts;

SELECT * FROM posts;

-- http://stevestedman.com/wp-content/uploads/TSqlJoinTypePoster.pdf

SELECT * FROM usuarios 
LEFT JOIN posts on usuarios.id = posts.usuario_id;
    
SELECT *
FROM usuarios 
LEFT JOIN posts on usuarios.id = posts.usuario_id
WHERE posts.usuario_id IS NULL;

SELECT *
FROM usuarios 
RIGHT JOIN posts on usuarios.id = posts.usuario_id;
    
SELECT *
FROM usuarios 
RIGHT JOIN posts on usuarios.id = posts.usuario_id
WHERE	posts.usuario_id IS NULL;

SELECT	*
FROM usuarios 
INNER JOIN posts on usuarios.id = posts.usuario_id;
    
SELECT	*
FROM usuarios 
JOIN posts on usuarios.id = posts.usuario_id;

SELECT	*
FROM usuarios 
LEFT JOIN posts   ON usuarios.id = posts.usuario_id
UNION 
SELECT	*
FROM usuarios 
RIGHT JOIN posts ON usuarios.id = posts.usuario_id;
    
SELECT *
FROM usuarios 
LEFT JOIN posts on usuarios.id = posts.usuario_id
WHERE	posts.usuario_id IS NULL
UNION
SELECT *
FROM usuarios 
RIGHT JOIN posts on usuarios.id = posts.usuario_id
WHERE posts.usuario_id IS NULL;