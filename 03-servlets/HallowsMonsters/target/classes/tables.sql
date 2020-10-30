-- this file is a copy, as a reference for table structure
create table monster_type(
	id serial primary key,
	type text,
	fur boolean,
	paws boolean
)

create table monster(
	id serial primary key,
	name text,
	monster_type integer references monster_type(id)
	
)



insert into monster_type(type, fur, paws) values 
	('werewolf',true, true), 
	('zombie', false, false),
	('ghost', false, false),
	('goblin', false, false),
	('swamp thing',false, true),
	('vampire',false, false),
	('alien',false, false);
	

select * from monster_type;
insert into monster (name, monster_type) values 
	('scruffs mcguffs', 1),
	('guzzmer', 5),
	('grendel',4),
	('dracula',6),
	('voldemort',6),
	('paul',7);
	
create view complete_monsters as select a.name, b.type as mtype, b.fur, b.paws from 
			monster a join monster_type b on a.monster_type = b.id;