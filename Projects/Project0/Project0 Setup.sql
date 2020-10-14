create table cars (
	CarID serial primary key,
	CarName text not null,
	Sold boolean
);

create table users (
	UserID serial unique,
	Username text,
	Password text,
	Employee boolean not null,
	primary key(UserID,Username)

);

create table payments(
	OwnerID int references users(UserID) on delete cascade,
	CarID int references cars(CarID) on delete cascade,
	MonthsLeft int not null,
	AmountLeft numeric(20,2) not null,
	PerMonth numeric(20,2) not null,
	Original numeric(20,2) not null,
	primary key (OwnerID,CarID)
);


create table offers(
	OfferID serial, 
	CustomerID int references users(UserID) on delete cascade,
	CarID int references cars(CarID) on delete cascade,
	Amount numeric (20,1) not null,
	Approved boolean default null,
	primary key (offerID)
);

--id is the offerid, car is the carid
create or replace procedure approve(id integer) as $$
declare 
	car integer;
	pmonth numeric(20,2);
	orig numeric(20,2);
	owne integer;
begin 
	--set the offer to approved
	update offers set Approved = true where offerid = id;
	select CustomerID,Amount,carid from offers into owne,orig,car where offerid = id; 
	--set the other offers to not approved
	update offers set Approved = false where carid = car and Approved is null;
	--set the car to sold
	update cars set sold = true where carid = car;
	--create a payment for the new car
	select getPerMonth(orig) into pmonth;
	insert into payments values (owne,car,63,orig,pmonth,orig);
end
$$language plpgsql;


create or replace function getPerMonth(a numeric(20,2)) returns numeric(20,2) as $$
	begin 
		return (ceil((a/63)*100))/100;
	end
$$ language plpgsql;


--need this to have an employee account.
insert into users values (0,'BigBoss','password',true);

--populate with some cars
insert into cars (CarName,Sold) values ('KiaTelluride', false);
insert into cars (CarName,Sold) values ('HyundaiKona',false);
insert into cars (CarName,Sold) values ('LamborghiniMurcielago',false);
insert into cars (CarName,Sold) values ('NissanLeaf', false);

drop table users cascade;
drop table cars cascade;
drop table payments;
drop table offers;
