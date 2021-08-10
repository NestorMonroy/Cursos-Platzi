--https://www.postgresql.org/docs/11/contrib.html
CREATE EXTENSION fuzzystrmatch;
--Cantidad de letras que cambian 
SELECT levenshtein ('nestor', 'nextor');
--Algoritmos de Matching-Learning- / aproximacion de palabras 0 - 4  donde 4 es muy similar
SELECT difference  ('nestor', 'nextor');

SELECT difference  ('beard', 'bird');

CREATE EXTENSION pgcrypto;

SELECT crypt('123456789', 'md5');
-- Esta función nos permite encriptar un password
-- segun la forma de encriptación