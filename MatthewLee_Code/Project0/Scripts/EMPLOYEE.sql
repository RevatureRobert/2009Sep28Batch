drop table employee;

create table employee (
	employee_id serial primary key,
	username text unique not null,
	password text not null
);

select * from employee;