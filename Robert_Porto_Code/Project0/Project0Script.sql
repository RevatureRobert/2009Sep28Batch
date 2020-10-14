
create table car (
	id serial primary key,
	make char(11),
	model char(11),
	year int,
	owner_id int references customer(id),
	balance int default 1000,
	orig_price int default 1000
)


create table employee (
	int
	id serial primary key,
	name char(15),
	password char (15)
)

create table customer (
	id serial primary key,
	name char(15),
	password char (15)
	
	
);

create table bid (
	id serial primary key,
	car_id int references car(id),
	customer_id int references customer(id),
	amount int
)



create or replace function show_available_cars() returns setof car as 
$$
begin
return query(select * from car where owner_id is null);
end
$$ language plpgsql;

select * from show_available_cars();



create or replace procedure delete_bids_for_carId(carId integer) 
	language sql as $$
	
	delete from bid where car_id = carID;
	
	$$;


truncate table bid;
truncate table car cascade;
truncate table customer cascade;


insert into employee (name, password) values ('rob', 'rob');

ALTER sequence car_id_seq RESTART WITH 1;
ALTER sequence bid_id_seq RESTART WITH 1;
ALTER sequence customer_id_seq RESTART WITH 1;

select * from car;
select * from customer;
select * from bid;
select * from employee;
