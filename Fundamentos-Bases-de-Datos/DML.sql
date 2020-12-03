-- Insert
INSERT INTO people (last_name, first_name, address, city)
VALUES ('Monroy', 'Nestor', 'Chihuahua 32 ', 'Mexico');

-- Update
UPDATE people
SET last_name = 'Monroy', city= 'Veracruz'
WHERE person_id = 1;

UPDATE people
SET first_name = 'Juan'
WHERE city = 'Mérida';

UPDATE people
SET first_name = 'Juan';

-- Delete
DELETE FROM people 
WHERE person_id = 1;

DELETE FROM people;

-- Select
SELECT fist_name, last_name FROM people;

