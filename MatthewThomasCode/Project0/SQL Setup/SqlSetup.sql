create table cd.cduser(
	user_id serial primary key,
	user_level integer,
	email text unique,
	username text unique not null,
	cd_password text not null

);
insert into cd.cduser (user_id ,user_level, email, username, cd_password) values (0,1,'CarDealership@CarDealership.com','system','wasspord');
insert into cd.cduser (user_level, email, username, cd_password) values (1,'james@james.net','jametron','12345');
insert into cd.cduser (user_level, email, username, cd_password) values (1,'johnathin@hoohle.net','jmann','54321');
insert into cd.cduser (user_level, email, username, cd_password) values (2,'geoff@CarDealership.com','g30ff','wasspord');

--select * from cd.cduser;
drop table cd.cduser; 
create table cd.customer(
	customer_id serial primary key,
	user_id int references cd.cduser(user_id) unique,
	first_name text,
	last_name text
	
);
insert into cd.customer (user_id, first_name, last_name) values (2, 'Johnathin','Thompson');
insert into cd.customer (user_id, first_name, last_name) values (1,'James','May');

--drop table cd.customer;


create table cd.car(
	car_id serial primary key,
	car_owner int references cd.cduser(user_id),
	make text,
	model text,
	car_year int,
	msrp numeric (20,2),
	payment numeric(20,2),
	principle numeric(20,2),
	debt numeric(20,2)

);

insert into cd.car (car_owner, make, model, car_year, msrp) values (0, 'Chevrolet', 'Colorado', 2004, 14999.99);
insert into cd.car (car_owner, make, model, car_year, msrp) values (0, 'Chevrolet', 'Silverado', 2004, 24999.99);
insert into cd.car (car_owner, make, model, car_year, msrp) values (0, 'GMC', 'Canyon', 2004, 16999.99);
insert into cd.car (car_owner, make, model, car_year, msrp) values (0, 'GMC', 'Sierra', 2004, 27999.99);

--select * from cd.car;

--drop table cd.car;


create table cd.offer(
	offer_id serial primary key,
	car_id int references cd.car(car_id),
	offer numeric(20,2),
	user_id int references cd.cduser(user_id)
);
--drop table cd.offer;

insert into cd.offer (car_id, offer, user_id) values (1, 13000.00, 1);
--select * from cd.offer;
create procedure cd.remove_offers(id integer) language sql as $$
	
	delete from cd.offer where car_id = (id);

$$;

--call cd.remove_offers(5);
--select * from cd.offer;