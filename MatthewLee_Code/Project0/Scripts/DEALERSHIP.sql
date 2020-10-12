drop view payments_with_offer;
drop table payment;
drop table offer;
drop table car;
drop table customer;
drop table employee;
drop table manager;

-- MANAGER
create table manager (
	manager_id serial primary key,
	username text unique not null,
	password text not null
);

insert into manager values (default, 'manager', 'project0');

-- EMPLOYEE
create table employee (
	employee_id serial primary key,
	username text unique not null,
	password text not null
);

-- CUSTOMER
create table customer (
	customer_id serial primary key,
	username text unique not null,
	password text not null
);

insert into customer values (-1, 'null', 'null');

-- CAR
create table car (
	car_id serial primary key,
	customer_id int default(-1) references customer(customer_id),
	
	make text not null,
	model text not null,
	year int not null,
	mpg int not null,
	price int not null
);

insert into car values (default, default, 'Nissan', 'Versa', 2020, 32, 18665);
insert into car values (default, default, 'Mitsubishi', 'Mirage', 2020, 36, 17190);
insert into car values (default, default, 'Hyundai', 'Accent', 2020, 33, 18625);
insert into car values (default, default, 'Toyota', 'Yaris', 2020, 30, 17645);
insert into car values (default, default, 'Kia', 'Rio', 2020, 33, 16815);
insert into car values (default, default, 'Chevrolet', 'Sonic', 2020, 26, 19495);

-- OFFER
create table offer (
	offer_id serial primary key,
	amount int not null,
	months int not null,
	accepted bool default(false) not null,
	
	customer_id int references customer(customer_id),
	car_id int references car(car_id)
);

-- PAYMENT
create table payment (
	payment_id serial primary key,
	monthly_payment int default(0),
	
	customer_id int references customer(customer_id),
	car_id int references car(car_id)
);

-- VIEW: PAYMENTS_WITH_OFFER
create view payments_with_offer as
select p.customer_id, p.car_id, sum(monthly_payment) as paid, avg(o.amount) as offer from payment p
join offer o on p.car_id = o.car_id
group by p.customer_id, p.car_id
order by p.customer_id, p.car_id;

-- PROCEDURE: ACCEPT_OFFER(OFFER_OFFER_ID INTEGER)
create or replace procedure accept_offer(offer_offer_id integer) language plpgsql as $procedure$
	declare 
		offer_customer_id integer;
		offer_car_id integer;
	begin	
		select offer.customer_id into offer_customer_id from offer where offer.offer_id = offer_offer_id;
		select offer.car_id into offer_car_id from offer where offer.offer_id = offer_offer_id;
		update car set customer_id = offer_customer_id where car_id = offer_car_id;
		delete from offer where car_id = offer_car_id and customer_id != offer_customer_id;
	end
$procedure$;