--constraints
--There are a number of constraints that our tables can have
----constraints
------unique
------not null
------primary key (combination of not null and unique)
------default (if a value is not specified, give some value)
------check (checks to see if something is true)
------foreign key

drop table bear;

create table bear (
	tag_id serial primary key, --put constraints on calls by putting them after datatype
	color text default('brown'),
	has_fur boolean default(true),
	belongs_to text references circus (name)
);

--when it comes to transactions, they are all or nothing, using the comma separator treats a whole line as if they're in a transaction block
--unique constraint will cause an error if you input a value in a column that is duplicate of another record
insert into bear values (1,'brown', true),(2, 'white',true);
--not null constraint will cause an error if you input a record with a null value in the column
insert into bear values (3, 'green', true);
--default constraint will add in the specified value if none is provided
insert into bear (tag_id, color) values (4, 'yellow');
--you can insert null if you explicitly tell sql to
insert into bear values (5, 'blue', null);
insert into bear (tag_id) values (6);
--check will check to see if some condition exists. it is essentially a way to provide custom rules for your table

--primary key
----combination of unique and not null
----different types of primary keys
------natural, surrogate, composite
----------natural = the primary key has meaning outside the database
----------surrogate = the key does not have meaning outside the db
----------composite = the key is made of two or more keys. the keys themselves do not need to be unique, the combination of them is unique

--serial
----serial is the numeric auto incrementing data type
insert into bear (has_fur) values (false),(false); --note, this starts at 1. you have to start with serial if you want to use it

select * from bear;

truncate table bear;

create table circus (
	name text primary key, --this key would be natural, the name of the circus has meaning outside the db
	ringleader text,
	is_entertaining boolean
);

create table bear (
	tag_id serial primary key, --this key is surrogate, it doesn't have meaning outside the db
	color text default('brown'),
	has_fur boolean default(true),
	belongs_to text references circus (name)
);

insert into circus values ('clowntown', 'john', true);

insert into bear (color, has_fur, belongs_to) values ('purple', false, 'clowntown');
insert into bear (color, has_fur, belongs_to) values ('plum crazy purple', false, null);

select * from bear;
select * from circus;

drop table bear;
drop table circus;

create table circus (
	name text primary key,
	ringleader text,
	is_entertaining boolean
);

create table bear (
	tag_id serial primary key, --put constraints on calls by putting them after datatype
	color text default('brown'),
	has_fur boolean default(true),
	belongs_to text references circus (name) unique
);

--multiplicity
----one to one
----one to many
----many to one
----many to many

--how to achieve each
----many to one and a one to many
----foreign key belongs in the many table
----------------------------------------
----one to one relationship
----make foreign key unique (doesn't matter which table you put the foreign key in)
----------------------------------------
----many to many
------a junction table is needed with a composite key that points to both tables
------and references a relationship for both tables.


--Referential integrity
----the child table holds a reference to the parent table and it cannot reference a record that is not present.

delete from circus where "name" = 'clowntown';
--the above statement will try to delete something from the parent table, and would cause the child to not
----point to a valid parent. This will cause an orphaned record.
--if we wanted to get rid of the parent, we would first need to get rid of the child.
--we can do this either by deleting the child first, or with cascading.