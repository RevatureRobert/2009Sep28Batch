create table users(
username text primary key;
user_password text not null;
email text not null
);
create table user_type(
belongs_to text references users (username);
user_acc boolean default(true);
emp_acc boolean not null;
cust_acc boolean not null
);
create table account_type(
belongs_to text references users (username);
checking boolean not null;
savings boolean not null
);
create table checking_balance(
belongs_to text references users (username);
balance integer default (0) not null
);
create table savings_balance(
belongs_to text references users (username);
balance integer default (0) not null
);
