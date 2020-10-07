-- comment inside of sql

-- Structured Query Language
---- 5 sublanguages of sql
--	dml, ddl, dcl, tcl, dql
----dml
------data manipulation language
----crud operations
-------create read update delete
----keywords
-------select, update, insert, delete

---ddl
------data definition language
---keywords
------create, alter, drop, truncate

----dcl
------data control language
----keywords
------grant and revoke

----dql
------data query language
----keywords
------select

----tcl
------transaction control language
----keywords
------begin, commit, rollback, savepoint



--dbms vs rdbms
----dbms
------data base management system
---------tables will not necessarily have any structure
----rdbms
------relational data base management system
--------tables will have a structure and will hold relations to other tables

--create table table_name(columns types constraints);
create table game_user (
	game text,
	max_player_count integer,
	basement_dweller boolean
);

--DML

-- insert into table_name (columnsToBeInsertedInto) values (valuesToBeInserted)
insert into game_user (game, max_player_count, basement_dweller) values ('gta',4,true);
--select (columns) from table_name;
select * from game_user;
--update table_name set column=value where column_name=value;
update game_user set basement_dweller = false where max_player_count=4;
--delete from table_name where column_name=value;
delete from game_user where basement_dweller=true;


--DDL

--alter [type of thing being altered] thing_name action type name datatype
alter table game_user add column game_platform text;

--truncate will empty the data in the tables
truncate table game_user;

--drop will destroy the tables altogether
drop table game_user;
select * from game_user;


--TCL
--- only works with dml

--begin marks the start of a transaction block.
begin;
	insert into game_user  values ('hello kitty the disaster', 3, false);
	select * from game_user;
--commit takes all the changes you have made and merges them with the actual table	
	commit;
-- rollback takes all the changes you have made since the last commit and trashes them.
	rollback;
end


begin;
	insert into game_user values ('halo',4, true), ('madden',4,true);
	select * from game_user;
	savepoint firs;
	update game_user set basement_dweller=false where game='madden';
	select * from game_user;
	rollback to firs;
	select * from game_user;
commit;


delete from game_user where game='halo' or game='madden';
select * from game_user;












