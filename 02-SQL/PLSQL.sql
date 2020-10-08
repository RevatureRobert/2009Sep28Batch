--PLSQL
----PLSQL=procedural language sql
------it is an extension to sql
----PLPGSQL
------procedural language postgresql sql
----languages supported by psql for plsql
------PLPGSQL
------C
------PERL
------RUBY
------R
------PYTHON
------and many more


-- functions
---- create [or replace] function [name] (params types) return [type] as [delimiter]
--		begin
--			[body]
--		end
---- [delimiter] language plpgsql



create or replace function sum(a integer, b integer) returns integer as '
	begin
		return a+b;
	end	
' language plpgsql;

select sum(2,3) as function_sum;

--or replace is optional
create function concat_sum(a integer, b integer, s text) returns text as '
	begin
		return a+b||s;
	end
' language plpgsql;

select concat_sum(5,6,'hello');
--------------------------------------------------------------------------------

create or replace function concat_sum2(a integer, b integer) returns text as $concat_sum2$
	begin
		return a+b||'hello';
	end
$concat_sum2$ language plpgsql;

select concat_sum2(9,2);
-----------------------------------------------------------------------------------
--how to access parameters by position rather than name
create or replace function mult(val1 integer, val2 integer, val3 integer) returns integer as $$
	begin
		return val1*val2*$3;
	end
$$ language plpgsql;

select mult(4,3,2);
-------------------------------------------------------------------------------------

--how to declare a variable inside a function
create or replace function create_var() returns text as $$
	declare
		album text;
		largest integer;
	--language specific
	begin
		select max("AlbumId") into largest from "Album";
		select "Title" into album from "Album" where "AlbumId"=largest;
		return album;
	end

$$ language plpgsql;

select create_var();
--------------------------------------------------------------------------
--anonymous functions
do $$

declare
		album text;
		largest integer;
	--language specific
	begin
		select max("AlbumId") into largest from "Album";
		select "Title" into album from "Album" where "AlbumId"=largest;
		insert into "Album" values (largest+1, album, 1);
	end
$$ language plpgsql;

select* from "Album" order by "AlbumId" desc;
---------------------------------------------------------------------------

create or replace function get_numbers_from_a()
	returns table(nums integer) as $$
	begin
		return query select number_a as nums from a;
	end
	$$ language plpgsql;

select get_numbers_from_a();
--------------------------------------------------------------------------

create or replace procedure insert_numbers(a integer, b integer) 
	language sql as $$
	
	insert into a values (a),(b);
	
	$$;

call insert_numbers(88,99);
select * from a;




