INSERT INTO actor (first_name, last_name) VALUES
('PENELOPE','GUINESS'),
('NICK','WAHLBERG'),
('ED','CHASE'),
('JENNIFER','DAVIS'),
('JOHNNY','LOLLOBRIGIDA'),
('BETTE','NICHOLSON'),
('GRACE','MOSTEL'),
('MATTHEW','JOHANSSON'),
('JOE','SWANK'),
('CHRISTIAN','GABLE'),
('ZERO','CAGE'),
('KARL','BERRY'),
('UMA','WOOD'),
('VIVIEN','BERGEN'),
('CUBA','OLIVIER'),
('FRED','COSTNER'),
('HELEN','VOIGHT'),
('DAN','TORN'),
('BOB','FAWCETT'),
('LUCILLE','TRACY');

INSERT INTO category(name) VALUES
('Action'),('Drama'),('Comedy'),('Horror'),('Family');

INSERT INTO film(title, description, language_id, rental_rate, length)
VALUES
('ACADEMY DINOSAUR','Epic drama',1,4.99,86),
('ACE GOLDFINGER','Action spy film',1,4.99,48),
('ADAPTATION HOLES','Emotional adventure',1,2.99,50),
('AFFAIR PREJUDICE','Romantic drama',1,0.99,117);

INSERT INTO customer(first_name,last_name,email,store_id)
VALUES
('MARY','SMITH','mary@example.com',1),
('JOHN','DOE','john@example.com',1);

INSERT INTO staff(first_name,last_name,address_id,store_id,username)
VALUES
('MIKE','HILL',1,1,'mike');

INSERT INTO store(address_id,manager_staff_id)
VALUES (1,1);

INSERT INTO inventory(film_id,store_id) VALUES
(1,1),(2,1),(3,1),(4,1);

INSERT INTO rental(rental_date,inventory_id,customer_id,staff_id)
VALUES (now(),1,1,1);

INSERT INTO payment(customer_id,staff_id,rental_id,amount,payment_date)
VALUES (1,1,1,2.99,now());
