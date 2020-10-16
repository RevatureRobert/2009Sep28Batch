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
insert into employee values(default, 'employee', 'project0');

-- CUSTOMER
create table customer (
	customer_id serial primary key,
	username text unique not null,
	password text not null
);

insert into customer values (-1, 'null', 'null');
insert into customer values (default, 'johndoe', 'johndoe');
insert into customer values (default, 'janedoe', 'janedoe');


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

-- OFFER
create table offer (
	offer_id serial primary key,
	amount int not null,
	months int not null,
	accepted int default(0) not null,
	
	customer_id int references customer(customer_id),
	car_id int references car(car_id)
);

insert into offer values (default, 18000, 60, default, 1, 1);
insert into offer values (default, 17000, 70, default, 2, 1);
insert into offer values (default, 17000, 70, default, 2, 2);

-- PAYMENT
create table payment (
	payment_id serial primary key,
	monthly_payment int default(0),
	
	customer_id int references customer(customer_id),
	car_id int references car(car_id)
);

-- VIEW: PAYMENTS_WITH_OFFER
create view payments_with_offer as
select p.customer_id, p.car_id, sum(monthly_payment) as paid, avg(o.amount) as offer, avg(o.months) as months from payment p
join offer o on p.car_id = o.car_id and o.accepted = 1
group by p.customer_id, p.car_id
order by p.customer_id, p.car_id;

-- PROCEDURE: ACCEPT_OFFER(OFFER_OFFER_ID INTEGER)
create or replace procedure accept_offer(offer_offer_id int) language plpgsql as $$
	declare 
		offer_customer_id integer;
		offer_car_id integer;
	begin	
		select offer.customer_id into offer_customer_id from offer where offer.offer_id = offer_offer_id;
		select offer.car_id into offer_car_id from offer where offer.offer_id = offer_offer_id;
		update car set customer_id = offer_customer_id where car_id = offer_car_id;
		update offer set accepted = 1 where offer.customer_id = offer_customer_id and offer.car_id = offer_car_id;
		update offer set accepted = -1 where car_id = offer_car_id and customer_id != offer_customer_id;
		insert into payment values (default, 0, offer_customer_id, offer_car_id);
	end
$$;

GRANT ALL ON TABLE dealership.car TO dealership_user;
GRANT ALL ON TABLE dealership.customer TO dealership_user;
GRANT ALL ON TABLE dealership.employee TO dealership_user;
GRANT ALL ON TABLE dealership.manager TO dealership_user;
GRANT ALL ON TABLE dealership.offer TO dealership_user;
GRANT ALL ON TABLE dealership.payment TO dealership_user;
GRANT ALL ON TABLE dealership.payments_with_offer TO dealership_user;

GRANT ALL ON SEQUENCE dealership.car_car_id_seq TO dealership_user;
GRANT ALL ON SEQUENCE dealership.customer_customer_id_seq TO dealership_user;
GRANT ALL ON SEQUENCE dealership.employee_employee_id_seq TO dealership_user;
GRANT ALL ON SEQUENCE dealership.manager_manager_id_seq TO dealership_user;
GRANT ALL ON SEQUENCE dealership.offer_offer_id_seq TO dealership_user;
GRANT ALL ON SEQUENCE dealership.payment_payment_id_seq TO dealership_user;