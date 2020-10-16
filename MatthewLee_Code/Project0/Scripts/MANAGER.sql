drop table manager;

create table manager (
	manager_id serial primary key,
	username text unique not null,
	password text not null
);

insert into manager (username, password) values ('manager', 'project0');

select * from manager;