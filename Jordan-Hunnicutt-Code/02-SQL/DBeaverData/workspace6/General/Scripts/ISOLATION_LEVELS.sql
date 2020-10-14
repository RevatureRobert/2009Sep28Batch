--isolation levels

--ACID, the i stands for isolation
----isolated = transactions will not conflict with each other

--						dirty read			Nonrepeatable Read				Phantom Read					Serialization Anomoly
--read uncommitted			O						O							 O									 O
--read committed			X						O							 O									 O
--repeatable read			X						X							 O(not in postgres)					 O
--serializable				X						X							 X									 X

--the more insured, the less performant

--note: postgresql does not allow read uncommitted as an isolation level, read committed is the minimum
--note: postgres does not allow phantom reads in a repeatable read

--read: (select)
--dirty read: data that gets read never having existed in the first place, you read from the wrong location
--phantom read: when you create a query and get 17 results, then do the same query and get 20 results later on
--nonrepeatable read: you create a query, but you can't perform it after all
--serialiaztion anomoly: multiple records with the same primary key are inserted, and one gets removed

--MVCC
----MultiVersion Concurrency control
------Postgres will create a snapshot of the db for your transaction block.
------Given that psql will do this, it will never hand you uncommitted information.
------It will give your transaction block an id and will keep track of which id is next in line.
------Depending on the selected isolation level, it will treat the locks on the db and your commits differently.

--example of using isolation level with transaction block
begin isolation level repeatable read;
	commit;
end;