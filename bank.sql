
-- CREATE TABLES FOR DATABASE
create table customers (
	customer_id serial primary key,
	firstname text not null,
	lastname text not null,
	email text not null unique,
	password text not null
);

create table accounts_pending (
	accounts_pending_id serial primary key,
	account_type text not null,
	customer_id int references customers (customer_id) not null
);

create table accounts(
	account_id int primary key,
	account_type text not null,
	balance int not null check (balance >= 0),
	customer_id int references customers(customer_id) not null
);

create table transactions (
	transaction_id serial primary key,
	transaction_type text not null,
	account_id_from int,
	account_id_to int,
	amount float not null,
	customer_id int references customers(customer_id)
);

create table employees (
	employee_id serial primary key,
	firstname text not null,
	lastname text not null,
	email text not null,
	password text not null
);

create table managers (
	employee_id int references employees(employee_id)
);

create table loans (
	loan_id serial primary key,
	principal float not null,
	interest float not null,
	accrued_interest float not null,
	term_months int not null,
	customer_id int references customers(customer_id)
);

create table loans_pending (
	loan_pending_id serial primary key,
	principal float not null,
	interest float not null,
	term_months int not null,
	credit_score int not null,
	customer_id int references customers(customer_id)
);

-- CREATE JDBC_WORKER AND GRANT ALL PRIVILEGES
create user jdbc_worker with password 'wasspord';
grant all privileges on schema public to jdbc_worker;

--custom stored procedure
create or replace procedure count_transactions()
	language sql as $$
	
	select count(transaction_id) from transactions;
	
	$$

create or replace procedure remove_pending()
	language sql as $$
	
	truncate table accounts_pending;
	
	$$

call remove_pending();
	
	
-- WARNING: RUN ONLY IF YOU WANT TO DELETE DATABASE
drop table customers cascade;
drop table accounts_pending cascade;
drop table accounts cascade;
drop table transactions cascade;
drop table employees cascade;
drop table managers cascade;
drop table loans cascade;
drop table loans_pending cascade;

--CREATE AN EMPLOYEE
insert into employees (employee_id, firstname, lastname, email, password) values(1, 'Jim', 'Drake', 'jd@gmail.com', 'password');

drop table employees;

--RUN IF GRANT ALL PRIVILEGES COMMAND DID NOT WORK
GRANT SELECT ON TABLE public.accounts TO jdbc_worker;
GRANT SELECT ON TABLE public.accounts_pending TO jdbc_worker;
GRANT SELECT ON TABLE public.customers TO jdbc_worker;
GRANT SELECT ON TABLE public.employees TO jdbc_worker;
GRANT SELECT ON TABLE public.loans TO jdbc_worker;
GRANT SELECT ON TABLE public.loans_pending TO jdbc_worker;
GRANT SELECT ON TABLE public.managers TO jdbc_worker;
GRANT SELECT ON TABLE public.transactions TO jdbc_worker;
GRANT INSERT ON TABLE public.accounts TO jdbc_worker;
GRANT INSERT ON TABLE public.accounts_pending TO jdbc_worker;
GRANT INSERT ON TABLE public.customers TO jdbc_worker;
GRANT INSERT ON TABLE public.employees TO jdbc_worker;
GRANT INSERT ON TABLE public.loans TO jdbc_worker;
GRANT INSERT ON TABLE public.loans_pending TO jdbc_worker;
GRANT INSERT ON TABLE public.managers TO jdbc_worker;
GRANT INSERT ON TABLE public.transactions TO jdbc_worker;
GRANT UPDATE ON TABLE public.accounts TO jdbc_worker;
GRANT UPDATE ON TABLE public.accounts_pending TO jdbc_worker;
GRANT UPDATE ON TABLE public.customers TO jdbc_worker;
GRANT UPDATE ON TABLE public.employees TO jdbc_worker;
GRANT UPDATE ON TABLE public.loans TO jdbc_worker;
GRANT UPDATE ON TABLE public.loans_pending TO jdbc_worker;
GRANT UPDATE ON TABLE public.managers TO jdbc_worker;
GRANT UPDATE ON TABLE public.transactions TO jdbc_worker;
GRANT DELETE ON TABLE public.accounts TO jdbc_worker;
GRANT DELETE ON TABLE public.accounts_pending TO jdbc_worker;
GRANT DELETE ON TABLE public.customers TO jdbc_worker;
GRANT DELETE ON TABLE public.employees TO jdbc_worker;
GRANT DELETE ON TABLE public.loans TO jdbc_worker;
GRANT DELETE ON TABLE public.loans_pending TO jdbc_worker;
GRANT DELETE ON TABLE public.managers TO jdbc_worker;
GRANT DELETE ON TABLE public.transactions TO jdbc_worker;
GRANT TRUNCATE ON TABLE public.accounts TO jdbc_worker;
GRANT TRUNCATE ON TABLE public.accounts_pending TO jdbc_worker;
GRANT TRUNCATE ON TABLE public.customers TO jdbc_worker;
GRANT TRUNCATE ON TABLE public.employees TO jdbc_worker;
GRANT TRUNCATE ON TABLE public.loans TO jdbc_worker;
GRANT TRUNCATE ON TABLE public.loans_pending TO jdbc_worker;
GRANT TRUNCATE ON TABLE public.managers TO jdbc_worker;
GRANT TRUNCATE ON TABLE public.transactions TO jdbc_worker;
GRANT REFERENCES ON TABLE public.accounts TO jdbc_worker;
GRANT REFERENCES ON TABLE public.accounts_pending TO jdbc_worker;
GRANT REFERENCES ON TABLE public.customers TO jdbc_worker;
GRANT REFERENCES ON TABLE public.employees TO jdbc_worker;
GRANT REFERENCES ON TABLE public.loans TO jdbc_worker;
GRANT REFERENCES ON TABLE public.loans_pending TO jdbc_worker;
GRANT REFERENCES ON TABLE public.managers TO jdbc_worker;
GRANT REFERENCES ON TABLE public.transactions TO jdbc_worker;
GRANT TRIGGER ON TABLE public.accounts TO jdbc_worker;
GRANT TRIGGER ON TABLE public.accounts_pending TO jdbc_worker;
GRANT TRIGGER ON TABLE public.customers TO jdbc_worker;
GRANT TRIGGER ON TABLE public.employees TO jdbc_worker;
GRANT TRIGGER ON TABLE public.loans TO jdbc_worker;
GRANT TRIGGER ON TABLE public.loans_pending TO jdbc_worker;
GRANT TRIGGER ON TABLE public.managers TO jdbc_worker;
GRANT TRIGGER ON TABLE public.transactions TO jdbc_worker;

--MUST RUN TO BE ABLE TO INSERT INTO TABLES WITH SERIAL TYPE
grant usage, select on all sequences in schema public to jdbc_worker;