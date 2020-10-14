-- Create a user
create user carDealer with password 'password';

-- Create tables
create table users (
	cust_id serial primary key,
	email text,
	username text unique,
	pass text,
	user_type integer default(1)
);
create table car (
	car_id serial primary key,
	make text,
	model text,
	car_year integer,
	color text,
	car_condition text,
	cust_id integer default(null) references users (cust_id) ON DELETE CASCADE
);
create table offer (
	offer_id serial primary key,
	cust_id integer references users (cust_id),
	car_id integer references car (car_id),
	offer integer,
	owed boolean default(false)
);

-- Create stored procedure
create or replace procedure clear_offers(a integer)
	language sql as $$
	delete from "carDealership".offer where car_id=a and owed=false;
$$

-- Grant all to cardealer
GRANT ALL ON TABLE "carDealership".car TO cardealer;
GRANT ALL ON TABLE "carDealership".users TO cardealer;
GRANT ALL ON TABLE "carDealership".offer TO cardealer;
GRANT ALL ON ALL SEQUENCES IN SCHEMA "carDealership" TO cardealer;
GRANT ALL ON ALL PROCEDURES IN SCHEMA "carDealership" TO cardealer;

-- Insert basic info
insert into users (Email, Username, Pass, user_type) values ('john@email.com', 'customer', '1',1),('man@email.com', 'manager', '1',3);
--('carlo@email.com', 'employee', '1',2)
insert into Car (Make, Model, Car_Year, Color, car_condition) values ('Ford','Expedition',1995, 'White', 'Used');
insert into Car (Make, Model, Car_Year, Color, car_condition) values ('Volkswagen','Beetle',1971, 'Red', 'Like-New');
insert into Car (Make, Model, Car_Year, Color, car_condition) values ('Dodge','Challenger',1973, 'Yellow', 'Heavily-Used');
insert into Car (Make, Model, Car_Year, Color, car_condition) values ('Ford','Pinto',1978, 'Teal', 'Used');
insert into Car (Make, Model, Car_Year, Color, car_condition) values ('Saturn','S-Series',1998, 'Red', 'Like-New');
insert into offer (cust_id, car_id, offer) values (1, 1, 7500);
insert into offer (cust_id, car_id, offer) values (1, 2, 4000);
insert into offer (cust_id, car_id, offer) values (1, 3, 7000);
insert into offer (cust_id, car_id, offer) values (1, 4, 2000);
insert into offer (cust_id, car_id, offer) values (1, 5, 1000);