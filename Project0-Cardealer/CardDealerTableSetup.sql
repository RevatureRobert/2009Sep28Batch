
create table cardealer."user"(
	username varchar(255) unique,
	userpassword varchar(255),
	lastname varchar(255),
	firstname varchar(255),
	isadmin boolean,
	ismanager boolean
	

) ;

create table cardealer."lot"(
	carID SERIAL PRIMARY KEY,
	carMaker varchar(255),
	carModel varchar(255),
	carYear varchar(255), 
	carColor varchar(255),
	carValue int,
	carOwned boolean default false
);

create table cardealer."offer"(
	offerID SERIAL primary key,
	userID varchar(255) references cardealer.user(username),
	carID INT references cardealer."lot"(carID),
	carOfferTotal INT,
	carOfferMonths INT
); 

create table cardealer."owned"(
	userID varchar(255) references cardealer.user(username),
	carID INT references cardealer."lot"(carID),
	carPaymentLeft INT,
	carMonthly INT
); 
