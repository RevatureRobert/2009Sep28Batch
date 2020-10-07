--isolation levels

--ACID, the i stands for isolation



--						dirty read		Nonrepeatable Read		Phantom Read		Serialization Anomoly
--read uncommitted			O					O					O						O
--read committed			X					O					O						O
--repeatable read			X					X					O(not in pg)			O
--serializable				X					X					X						X

--the more insured, the less performant


--MVCC
----MultiVersion Concurrency Control
------Postgres will create a snapshot of the db for your transaction block.
------Given that psql will do this, it will never hand you uncommitted information.
------It will give your transaction block an id and will keep track of which id is
------next in line. Depending on the selected isolation level, it will treat the locks
------on the db and your commits differently.

--example of using isolation level with transaction block

begin isolation level serializable;
	commit;
end;




