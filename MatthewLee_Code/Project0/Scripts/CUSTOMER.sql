drop table customer;

create table customer (
	customer_id serial primary key,
	username text unique not null,
	password text not null
);

insert into customer values (-1, 'null', 'null');

select * from customer;