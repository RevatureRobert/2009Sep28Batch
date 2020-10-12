--basic query
select * from game_user;

select * from "Track";

---WHERE clause;
select * from "Track" where "Composer"='AC/DC';

--SELECT A COLUMN
select "Name" from "Track" where "Composer"='AC/DC';

--SELECT COLUMNS
select "Name", "Milliseconds" from "Track" where "Composer"='AC/DC';

--ALIAS
select "Name" as track_name from "Track" where "Composer"='AC/DC';

--sorting

select * from "Track" order by "Composer";
select * from "Track" order by "Composer", "Name";

 --ASCENDING BY DEFAULT, YOU CAN STATE IT EXPLICITY  
select * from "Track" order by "Composer", "Name" asc;

--descending
select * from "Track" order by "Composer", "Name" desc;

--less than
select * from "Track" where "Milliseconds"<300000 order by "Composer";

--like clause. % is the wildcard for multiple characters
select * from "Track" where "Composer" like 'Audio%'

--"_" is the wildcard for a single character
select * from "Track" where "Composer" like 'Apocalypti__'

select * from "Track";

-- query where something is null
select * from "Track" where "Composer" is null;

--query where something is not null
select * from "Track" where "Composer" is not null;

--query where something is not equal to something
select * from "Track" where "GenreId" != 1;
select * from "Track" where "GenreId" <> 1;

-- between clause
select * from "Track" where "Milliseconds" between 200000 and 300000;

--and clause
select * from "Track" where "Milliseconds" between 200000 and 300000 and "Composer" = 'AC/DC';

--or clause
select * from "Track" where "Milliseconds" between 200000 and 300000 or "Composer" = 'AC/DC';

--subqueries
select * from "Track" where "GenreId" in (
	select "GenreId" from "Genre" where "Name" like 'R%'
);

create view songs_with_genre_r as select * from "Track" where "GenreId" in (
	select "GenreId" from "Genre" where "Name" like 'R%'
);


select * from songs_with_genre_r;
