create table user_acc (
	user_id serial  primary key,
	username varchar(50) unique NOT NULL,
	password varchar(50) NOT NULL,
	first varchar(100) NOT NULL,
	last varchar(100) NOT NULL,
	email varchar(150) unique NOT NULL,
	role_id int references user_role(user_role_id) NOT NULL
)

create table user_role (
	user_role_id serial primary key,
	user_role varchar(10)
	
)


create table reimbursement (
	reim_id serial primary key,
	amount int,
	submitted TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	resolved timestamp,
	description varchar(250),
	reciept bytea,
	author_id int references user_acc(user_id) NOT NULL,
	resolver_id int references user_acc(user_id),
	status_id int references reimbursement_status(status_id) NOT null default 1,
	type_id int references reimbursement_type(type_id) NOT NULL
)

create table reimbursement_status (
	status_id serial primary key,
	status varchar(10)
)

create table reimbursement_type (
	type_id serial primary key,
	type varchar(15)
)


insert into user_role (user_role) values ('gladiator');
insert into user_role (user_role) values ('manager');
insert into reimbursement_status (status) values ('pending');
insert into reimbursement_status (status) values ('denied');
insert into reimbursement_status (status) values ('approved');

insert into reimbursement_type (type) values ('lost limb');
insert into reimbursement_type (type) values ('impalement');
insert into reimbursement_type (type) values ('blunt trauma');
insert into reimbursement_type (type) values ('decapitation');


			
insert into user_acc (username, password, first,last, email, role_id) values ('gladboy09','pass','jo','shmo','glad@gmail.com', 1);
insert into user_acc (username, password, first,last, email, role_id) values ('go4it','pass','Derek','Derekson','DD@gmail.com', 1);
insert into user_acc (username, password, first,last, email, role_id) values ('luv2fight','pass','Terry','Green','tjshmit@ail.com', 1);

insert into user_acc (username, password, first,last, email, role_id) values ('man','pass','man','man','largeNiNCharge@yahoo.com', 2);

insert into reimbursement(amount, description, author_id , status_id, type_id) values (1000,'This was a good thing',1,2,1);

--make a manager account
insert into user_acc (username, password, first,last, email, role_id) values ('robert','pass','robert','porto','robert@gmail.com', 2);


select * from user_acc;
select * from user_role;
select * from reimbursement;
select * from reimbursement_status;
select * from reimbursement_type;

--ALTER sequence reimbursement_reim_id_seq RESTART WITH 6;

create or replace procedure approve_reimbursement(rid integer, uid integer) 
	language sql as $$
	
	update reimbursement set status_id = 1 where reim_id = rid;
	update reimbursement set resolver_id = uid where reim_id = rid;
	update reimbursement set resolved = current_timestamp where reim_id = rid;

	
	
	$$;

create or replace procedure deny_reimbursement(rid integer, uid integer) 
	language sql as $$
	
	update reimbursement set status_id = 3 where reim_id = rid;
	update reimbursement set resolver_id = uid where reim_id = rid;
	update reimbursement set resolved = current_timestamp where reim_id = rid;

	
	
	$$;
	

---------------------function to hash passwords and to work  with trigger 
-------change the salt keyword for your own project -------make sure all columns match your table 
 create or replace
function hashPassword() returns trigger as $$ begin if(new.password = old.password)then return new;
end if;

new.password := md5(new.password);

return new;
end;

$$ language plpgsql; 


----------create the trigger that will call the function  when needed 
 create trigger hashPass before
insert
	or
update
	on
	user_acc for each row execute function hashPassword();
	
create view complete_reimbursement  as select r.reim_id as id , u.username, r.submitted, r.description, rs.status, rt.type, r.amount from user_acc u, reimbursement r, reimbursement_status rs, reimbursement_type rt where u.user_id = r.author_id and rs.status_id = r.status_id and rt.type_id = r.type_id ;

--truncate table user_acc cascade;
--ALTER sequence user_acc_user_id_seq RESTART WITH 1;
--
--truncate table reimbursement cascade;
--ALTER sequence reimbursement_reim_id_seq RESTART WITH 1;

