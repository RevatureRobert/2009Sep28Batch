drop view payments_with_offer;
drop table offer;

create table offer (
	offer_id serial primary key,
	amount int not null,
	months int not null,
	accepted int default(0),
	
	customer_id int references customer(customer_id),
	car_id int references car(car_id)
);

select * from offer;