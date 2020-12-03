CREATE DATABASE blog_db;

USE blog_db;

CREATE TABLE people (
	person_id int,
	last_name varchar(255),
	first_name varchar(255),
	address varchar(255),
	city varchar(255) 
);

CREATE VIEW v_mexico_customers AS
    SELECT customer_name, contact_name
    FROM customers
    WHERE country = "Mexico";