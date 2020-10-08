--basic query
select * from game_user;

select * from track;

--Where clause
select * from track where composer = 'Angus Young, Malcolm Young, Brian Johnson';
--SELECT A COLUMN(S)
select  name, milliseconds from track where composer  = 'Angus Young, Malcolm Young, Brian Johnson';
-- ALIAS
select name as track_name from track where composer = 'Angus Young, Malcolm Young, Brian Johnson';

--sorting
select * from track order by composer, "name" desc;
-- acending by defaultm you can state it explicitly by stating asc. Decending is desc.

-- less than
select * from track where milliseconds <300000 order by composer;

-- like clause, % is wildcard for multiple characters
select * from track where composer like 'Audio%';

-- like clause, _ is the wildcard for one character
elect * from track where composer like 'A__io%';

-- = null
select * from track where composer is null;

-- != null
select * from track where composer is not null;

-- !=
select * from track where genre_id != 1;

-- Between clause
select * from track where milliseconds between 200000 and 300000;

-- And Clause
select * from track where milliseconds between 200000 and 300000 and composer = 'AC/DC';
-- Or Clause
select * from track where milliseconds between 200000 and 300000 or composer = 'AC/DC';

--subqueries
select * from track where genre_id in (
	select genre_id from  genre where name like 'R%'
);

-- views
create view songs_with_genre_r as select * from track where genre_id in (
	select genre_id from  genre where name like 'R%'
);
select * from songs_with_genre_r;

-- different types of functions

	--aggregate and scalar

------aggregate works with multiple values
----------count, avg, sum
------scalat works with singular values
----------floor, ceil, round, abs

--- aggregate function works with multiple values
select count(track_id) from songs_with_genre_r;

--scalar functions work with a single value
select abs(-100);

-- see the duplicates? we want to know how many tracks are composed by each author
select composer from songs_with_genre_r;

-- how many tracks by each author where the genre starts with r
select count(track_id) as tracks, composer from songs_with_genre_r group by composer; 

-------------constraints----------------------------------------------------------------------
--	there are a number of constraints that our tables can have
	--constraints
		--unique
		--not null
		--primary key (combination of not null and unique
		--default
		--check -- the check constraint will check to see if some condition exists it is essentially a way to provide custom rules for your table
		--foreign key
		
create table bear (
	tag_id integer primary key, 
	color text,
	has_fur boolean default(true)
)

--serial
-----serial; is the numeric auto incrimenting data type


--LOOK AT HIS NOTES

--ACID
	-- the properties of transaction
		--atomic, consistent, isolated, durable

		--atomic - all or nothing
		--consistent - all the constraints are being followed, the state of the DB propperly changes after a commit
		--isolated - transactions will not conflict with each other
		--durable - information will persist in the event of bad circomstances

--Normalization
-- normalization is the way that we can organize our datea to reduce redundancy and provide a better optimization

-- normalization is made up by many normal forms
	-- these are the forms for the tables
		--first normal form (1nf)
			--each row of data must have a unique identifier (primary key)
			--each row must have atomic (granular) values
		
		--(2nf)
			--must be in 1nf
			--any non key field should be dependent on the primary key (no partial dependencies)
				-- if the table has no composite key, it is in 2nf
		--3nf
			--must be in 2nf
			--no transitive dependencies
				--all must depend on the primary key
				
-- the first there normal forms are known as the Boyde-codd forms
	--the key, the whole key, nothing but the key, so help me Codd.
	

--Isolation Levels
	--ACID, the I stands for Isolation
	
--					dirty read -where the info used to exist, but does no longer	Nonrepeatable Read	Phantom Read					Serialization Anomoly
--read uncommited		0																0					0								0					Postgress does not allow
--read commited			X																0					0								0					Postgress minimum isolation level
--repeatable read		X																X					0(pg does not allow this)		0
--serializable			X																X					X								X					slowest

--the more insured, the less performant

--MVCC
-- MultiVersion Concurancy Control 
--		Postgres will creat a snapshot of the db for your transaction block. 
---		Given that psql will do this, it will never hand you uncommited information.
--		It will give your tansaction block an id and will keep track of whic id is next in line.
--		Depending on the selected isolation levelm it will treat the locks on the db and your commits differently.

-- example of using isolation level with transaction block;
begin isolation level repeatable  read;
	commit;
end;

--PLSQL
----PLSQL = Procedural Language SQL
-----it is an extention to sql
---PLPGSQL
	--ProceduralLanguagePostgresSQL
	--Languages supported by psql for plsql
		--PLPGSQL
		--C
		--Perl
		--R
		--Ruby
		--Python
		--and many more
	--writing functions
		--create [or replace] function [name] (parameter types) return [type] as [delimiter]
			--begin
				--[Body of Function]
			--end
		--[delemeter] language plpgsql

create or replace function sum(a integer, b integer) returns integer as '
	begin
		return a+b;
	end
' language plpgsql;
-- or replace is optional

select sum(2,3);

--anonomus functions

do $$
	declare
			album text;
			largest integer;
	begin
			select max(album_id)into largest from album;
			select title into album from album a2  where album_id = largest;
			insert into album values (largest+1, album, 1);
	end
$$ language plpgsql;

--procedure (void function)

create or replace procedure insert_numbers(a integer, b integer)
	language sql as $$ 
	
	insert into [table] values (a),(b);
	
	$$;	
call insert_numbers(88,99);
select * from [table];

-------Triggers
create table colors (
	id serial primary key,
	color text
);
drop table colors;


insert into colors (color) values ('red'),('blue'),('brown'); 

select * from colors;

--tg_op trigger opperation, holds information about what is happening
create or replace function no_more_blues()
	returns trigger as $$
		begin 
			if(tg_op = 'insert') then 
			--new is the new value
				if(upper(new.color) = 'BLUE') then
					return null;
				end if;
			end if;
			if (upper(new.color) = 'BLUE') then
				return old;
			end if;
			return new;
		end
	
	$$ language plpgsql;

create trigger no_blues_trigger
	before insert or update on colors
	for each row 
	execute function no_more_blues();
--create trigger [name]
--[before, after, instead of][insert, update, delete] on [table]
--for each [row, statement]
--execute [function or procedure] [name]

drop trigger no_blues_trigger on colors;

select * from colors;

update colors set color = 'blue' where id=1;

--sequence
-- a sequence will begin a swquence of numbers and keep track of the current value to use the values we can use next val ('seq name') ti get a unique value

create sequence seq5 start 5 increment by 5;

select nextval('seq5');