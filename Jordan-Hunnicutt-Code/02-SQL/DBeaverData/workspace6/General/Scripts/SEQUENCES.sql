------sequences
--a sequence will begin a sequence of numbers and keep track of the current value.
----to use the values, we can use nextval('seq_name') to get a unique value.

--behind the scenes, serial uses a sequence to increment
--we can customize by starting with whatever number and changing it how we like
create sequence seq5 start 5 increment by 5;

select nextval('seq5');

create sequence start6 start 6;

select nextval('start6');

create or replace function primary_key_gen() returns trigger as $$
	begin
		if(new.id=0) then
			new.id:=nextval('start6');
		end if;
		return new;
	end

$$ language plpgsql;

create table simpletab (
	id integer primary key,
	something text
);

create trigger simpleTrig
	before insert on simpletab
	for each row
	execute function primary_key_gen();
	
insert into simpletab values (0, 'idjgbre');
select * from simpletab;