-- comment inside of sql

-- Structured Query Language
---- 5 sublanguages of sql
-- dml, ddl, dcl, tcl, dql
----dml
-----data manipulation language
-----crud operations (most often)
-------create read update delete
-----keywords
-------select (read), update, insert (create), delete

----ddl
------data definition language (structure)
------keywords
--------create, alter, drop, truncate

----dcl
------data control language (who can access)
----keywords
------grant and revoke

----dql
------data query language (who to create a query)
------keywords (only has one, so it isn't always mentioned)
--------select

----tcl
------transaction control language
------keywords
--------begin, commit, rollback, savepoint


--dbms vs rdbms
----dbms
------data base management system
---------tables will not necessarily have any structure
---------flexible with storage
----rdbms
------relational database management system
--------tables will have a structure and will hold relations to other tables
--------flexible with queries

----note, we use _ because everything without "" around it turns into lowercase. cant use uppercase or camelCase


--------DML STATEMENTS
--create table table_name(columns types constraints)
create table game_user (
	game text,
	max_player_count integer,
	basement_dweller boolean
);
--note, cannot create duplicate tables

--insert into table_name (columnsToBeInsertedInto) values (valuesToBeInserted)
insert into game_user (game, max_player_count, basement_dweller) values ('gta',4,true);

--select (columns) from table_name; ----- * means all columns
select * from game_user;

--update table_name set column = value where column_name = value
update game_user set basement_dweller = false where max_player_count = 4;

update game_user set (max_player_count, basement_dweller) = (2, false) where game = 'gta';

--delete from table_name where column_name = value
delete from game_user where basement_dweller = true;


--------DDL STATEMENTS
--alter can do a lot of different things, hard to pin down syntax
--alter [type of thing being altered] thing_name action[add/drop/etc] type[column/constraint/etc] name datatype
alter table game_user add column game_platform text;

--deletes all data entries from a table
--truncate can only be used on tables
truncate table game_user;

--deletes the entire table itself
--delete can be used on other things
drop table game_user;

--note, postgre comes with autocommit
---------TCL STATEMENTS
--only works with dml
--begin marks the start of a transaction block.
--NOTE: you can highlight a line with your mouse, right click, and run only that sql statement
begin;
	--shortcut, you can just put values without specifying if you'll enter data for every column
	insert into game_user values ('hey there', 3, false);
	select * from game_user;
	--commit takes all the changes you have made and merges them with the actual table
	commit;
	--rollback takes all the changes you have made and trashes them
	rollback;
end;

--TCL commands can ONLY run inside of a transaction block
begin;
	--another shortcut, you can insert multiple rows with one insert statement
	insert into game_user values ('halo',4,true), ('madden',4,true);
	select * from game_user;
	--savepoint creates a backup/checkpoint
	savepoint firs;
	update game_user set basement_dweller = false where game='madden';
	select * from game_user;
	--you can rollback to a specific savepoint rather than just the last commit
	rollback to firs;
	select * from game_user;
	commit;
	delete from game_user where game='halo' or game='madden';
	select * from game_user;
end;

