drop view payments_with_offer;
drop table payment;

create table payment (
	payment_id serial primary key,
	monthly_payment decimal default(0),
	
	customer_id int references customer(customer_id),
	car_id int references car(car_id)
);

select * from payment;