drop table car;

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

select * from car;
update car set customer_id = -1 where car_id = 1;