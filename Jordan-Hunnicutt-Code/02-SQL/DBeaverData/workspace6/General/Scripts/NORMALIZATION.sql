-------------NORMALIZATION
--normalization is the way that we can organize our data to reduce redundancy and provide better optimization

--normalization is made up by many normal forms
----these are the forms for the tables

--first normal form (1nf)
----each row of data must have a unique identifier
----each row must have atomic values (granularizing the data) (different from atomic in acid)
--example:
----a table with an address column
------insert into address_table values ('555 55th street indianapolis, IN 44444');   <- bad
----with first normal form:
------insert into address (1, 555, '55th street', 'Indianapolis', 'IN', 44444); <- better (easier and faster to query)

--second normal form (2nf)
----must be in 1nf
----any non key field should be dependent on the primary key (no partial dependencies)
------if the table has no composite key, its in 2nf
--example
---- user_table -> | userid | addr_id | user_information | address_information | <- bad
---- user_table -> | userid | user_information | ... addr_table | addr_id | address_info | <- better

--third normal form (3nf)
----must be in 2nf
----no transitive dependencies
--example
----student_table -> | id | name | gpa | letter_grade | <- bad (letter_grade depends on gpa)
----student_table -> | id | name | gpa | ... lookup -> | gpa | letter_grade |

--the first three normal forms are known as the Boyde-codd forms (Boyde and Codd made them)
--the key, the whole key, nothing but the key, so help me Codd