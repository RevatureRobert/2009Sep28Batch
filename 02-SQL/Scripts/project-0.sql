create table users(
username text primary key,
user_password text not null,
email text not null,
user_acc boolean default(true),
emp_acc boolean default (false),
cust_acc boolean default(false),
has_checking boolean default (false),
cheking_balance integer default (0.00),
has_savings boolean default(false),
savings_balance integer default(0.00)
);

create user bank_user with password 'password';
grant all privileges on schema bank_schema to bank_user;
grant all privileges on schema public to bank_user;

select * from users; 
insert into users (username, user_password, email) values ('fdjasl', 'dsafdsa', 'drip');
drop table users;