-- ===============================
-- PAGILA SCHEMA (PostgreSQL)
-- ===============================

CREATE EXTENSION IF NOT EXISTS plpgsql;

CREATE TABLE actor (
    actor_id SERIAL PRIMARY KEY,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    last_update TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE category (
    category_id SERIAL PRIMARY KEY,
    name VARCHAR(25) NOT NULL,
    last_update TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE film (
    film_id SERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    release_year INT,
    language_id INT NOT NULL,
    rental_duration INT NOT NULL DEFAULT 3,
    rental_rate NUMERIC(4,2) NOT NULL DEFAULT 4.99,
    length INT,
    replacement_cost NUMERIC(5,2),
    rating VARCHAR(10),
    last_update TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE film_actor (
    actor_id INT NOT NULL REFERENCES actor(actor_id),
    film_id INT NOT NULL REFERENCES film(film_id),
    last_update TIMESTAMP NOT NULL DEFAULT now(),
    PRIMARY KEY (actor_id, film_id)
);

CREATE TABLE film_category (
    film_id INT NOT NULL REFERENCES film(film_id),
    category_id INT NOT NULL REFERENCES category(category_id),
    last_update TIMESTAMP NOT NULL DEFAULT now(),
    PRIMARY KEY (film_id, category_id)
);

CREATE TABLE customer (
    customer_id SERIAL PRIMARY KEY,
    store_id INT NOT NULL,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    email VARCHAR(50),
    active BOOLEAN NOT NULL DEFAULT TRUE,
    create_date DATE NOT NULL DEFAULT now(),
    last_update TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE store (
    store_id SERIAL PRIMARY KEY,
    manager_staff_id INT,
    address_id INT NOT NULL,
    last_update TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE staff (
    staff_id SERIAL PRIMARY KEY,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) NOT NULL,
    address_id INT NOT NULL,
    email VARCHAR(50),
    store_id INT NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE,
    username VARCHAR(16) NOT NULL,
    password VARCHAR(40),
    last_update TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE inventory (
    inventory_id SERIAL PRIMARY KEY,
    film_id INT NOT NULL REFERENCES film(film_id),
    store_id INT NOT NULL,
    last_update TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE rental (
    rental_id SERIAL PRIMARY KEY,
    rental_date TIMESTAMP NOT NULL,
    inventory_id INT NOT NULL REFERENCES inventory(inventory_id),
    customer_id INT NOT NULL REFERENCES customer(customer_id),
    return_date TIMESTAMP,
    staff_id INT NOT NULL REFERENCES staff(staff_id),
    last_update TIMESTAMP NOT NULL DEFAULT now()
);

CREATE TABLE payment (
    payment_id SERIAL PRIMARY KEY,
    customer_id INT NOT NULL REFERENCES customer(customer_id),
    staff_id INT NOT NULL REFERENCES staff(staff_id),
    rental_id INT REFERENCES rental(rental_id),
    amount NUMERIC(5,2) NOT NULL,
    payment_date TIMESTAMP NOT NULL
);

-- Indexes
CREATE INDEX idx_film_title ON film (title);
CREATE INDEX idx_actor_last_name ON actor (last_name);
CREATE INDEX idx_customer_last_name ON customer (last_name);
CREATE INDEX idx_inventory_film_id ON inventory (film_id);
CREATE INDEX idx_rental_customer_idx ON rental(customer_id);
