create table ers_reimb (
  reimb_id  serial primary key,
  reimb_amt real not null,
  reimb_submitted timestamp,
  reimb_resolved timestamp,
  reimb_description varchar(30) not null,
  reimb_receipt varchar(30) not null,
  reimb_author varchar(30) not null,
  reimb_resolver varchar(30),
  reimb_stat_id integer references ers_reimb_stat,
  reimb_type_id integer references ers_reimb_type
);

create table ers_reimb_type (
  reimb_type_id serial primary key,
  reimb_type varchar(30) unique not null
);

create table ers_reimb_stat (
  reimb_stat_id serial primary key,
  reimb_stat varchar(30) unique not null
);

create table ers_usrs (
	ers_usrs_id serial primary key,
	ers_usrnm varchar(30) unique not null,
	ers_pswd varchar (30) not null,
	usr_fst_nm varchar(30) not null,
	usr_lst_nm varchar(30) not null,
	usr_eml varchar(30) not null,
	usr_role_id integer references ers_usr_roles
);

create table ers_usr_roles (
  ers_usr_role_id serial primary key,
  usr_role varchar(30) not null unique
);

