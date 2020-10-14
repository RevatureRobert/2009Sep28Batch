-- comment inside of sql

-- sql = structured query language
-- 5 sublanguages
-- dml  = data manipulation language
		-- CRUD
		-- Create	insert
		-- Read		select
		-- Update	update
		-- Delete	delete
-- ddl	=  data definition language
		-- Create 	 
		-- Alter
		-- Drop
		-- Truncate
-- dcl	=	data control language
		--	grant
		-- 	revoke
	
-- tcl	= 	transaction control language
		--	begin
		-- 	commit
		-- 	rollback
		-- 	savepoint
	
-- dql	=	data query language
		--	select



-- DBMS vs RDBMS
--	DBMS
		--data base management system
			--tables will not necessarilly have any structure
-- RDBMS
		--relational data base management system
			-- tables will have a structure and will hold relations to other tables
			
-- create table table_name(columns types constraints);
create table game_user (	--CREATE TABLE NAMED GAME_USER
	game text,
	max_player_count integer,
	basement_dweller boolean
);

--DML
-- insert into table_name(columnsToBeInsertedInto) values (valuesToBeInserted)
insert into game_user (game, max_player_count, basement_dweller) values('gta',4,true);
-- select (columns) from table_name
select * from game_user;
--update table_name set column = value where column_name = value;
update game_user set basement_dweller = false where max_player_count=4;
-- delete from table_name where column_name = value;
delete from game_user where basement_dweller = true;

-- DDL
-- alter [type of thing being altered] thing_name action type name datatype
alter table game_user add column game_platform text;
--
truncate table game_user;--deletes all from inside table

drop table game_user; --delete the table from existence

--TCL
-- ONLY WORKS WITH DML LANGUAGE

--begin marks the start of a transaction block.
begin;
	insert into game_user (game, max_player_count, basement_dweller) values ('skyrim', 3, false);
	commit; -- commit takes all changes you have made and merges them with the real table.
	rollback; -- rollback takes all the changes you have made since the last commit and trashes them.
end

begin;
	insert into game_user values ('halo', 4, true),('call of duty', 3, true);
	savepoint firs;
	select * from game_user;
	update game_user set basement_dweller = false where game = 'halo' or game = 'call of duty';
	select * from game_user;
	rollback to firs;
	select * from game_user;
commit;