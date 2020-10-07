--------------------NORMALIZATION
--normalization is the way that we can organize our data 
----to reduce redundancy and provide better optimization

--normalization is made up by many normal forms
----these are the forms for the tables

--first normal form (1nf)
----each row of data must hace a unique identifier (primary key)
----each row must have atomic values (granularizing the data)
--example:
----a table with an address column
------insert into address_table values ('555 55th street jacksonville, FL 33333'); <-bad
----with first normal form:
------insert into address (1, 555, '55th ST', Jacksonville','FL',33333); <-better

--second normal form (2nf)
----must be in 1nf
----any non key field should be dependent on the primary key (not partial dependencies)
------if the table has no composite key, its in 2nf
--example
---- user_table -> | userid | addr_id | user_information | address_information | <- bad
---- user_table -> | userid | user_information | ... addr_table -> | addrid | addr_info | <- better

--third normal form (3nf)
----must be in 2nf
----no transitive dependencies
--example
----student_table -> | id | name | gpa | letter_grade | <- bad
----student_table -> | id | name | gpa | ... lookup -> | gpa | letter_grade | <- better

--the first three normal forms are known as the Boyde-codd forms
-- the key, the whole, nothing but the key, so help me Codd