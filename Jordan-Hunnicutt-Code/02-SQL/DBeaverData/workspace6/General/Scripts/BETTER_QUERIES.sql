--basic query
SELECT * FROM game_user;

--double quotes, specifically looks for table or column with name, quotes ensures we keep capitalization
select * from "Track";

--Where clause
select * from "Track" where "Composer" = 'AC/DC';

--SELECT A COLUMN
select "Name" from "Track" where "Composer" = 'AC/DC';

--SELECT COLUMNS
select "Name", "Milliseconds" from "Track" where "Composer" = 'AC/DC';

--ALIAS
select "Name" as track_name from "Track" where "Composer" = 'AC/DC';
--note: we can't now select track_name. this is just a view of the table, not the table itself

--sorting
select * from "Track" order by "Composer";
select * from "Track" order by "Composer", "TrackId";
--ASCENDING by default, YOU CAN STATE IT EXPICILTLY
select * from "Track" order by "Composer", "TrackId" asc;
--descending
select * from "Track" order by "Composer" desc, "TrackId" desc;
--less than
select * from "Track" where "Milliseconds" < 300000 order by "Composer";
--like clause. % is the wildcard for multiple characters
select * from "Track" where "Composer" like 'Audio%';
--underscore is wildcard for one character (each)
select * from "Track" where "Composer" like 'A__io%';
select * from "Track" where "Composer" like 'Apocalypti_'; --doesn't return results (composer is Apocalyptica)
--can't say equals null, have to use is, same with is not
select * from "Track" where "Composer" is null;
select * from "Track" where "Composer" is not null;
--query where something is not equal to something
select * from "Track" where "GenreId" != 1;
select * from "Track" where "GenreId" <> 1; --is less than or greater than 1
--between clause
select * from "Track" where "Milliseconds" between 200000 and 300000;
--and clause and or clause
select * from "Track" where "Milliseconds" between 200000 and 300000 and "Composer" = 'AC/DC';
select * from "Track" where "Milliseconds" between 200000 and 300000 or "Composer" = 'AC/DC';

--SUBQUERIES
select * from "Track" where "GenreId" in (
	select "GenreId" from "Genre" where "Name" like 'R%'
);
--create a view, which is the table with these selects
--makes it easier to do complicated selects, dont have to have 5 nested lines, just use a view
create view songs_with_genre_r as select * from "Track" where "GenreId" in (
	select "GenreId" from "Genre" where "Name" like 'R%'
);
select * from songs_with_genre_r;
