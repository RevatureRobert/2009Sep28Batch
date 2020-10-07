--different types of functions
-- aggregate and scalar

----aggregate works with multiple values
-------count, avg, sum
----scalar works with singular
-------floor, ceil, round, abs

--aggregate function works with multiple values
select count("TrackId") from "Track";
select count("TrackId") as how_many_tracks_start_with_r_for_its_genre from songs_with_genre_r;

--scalar functions work with single values
select abs(-100);

--see the duplicates? we want to know how many tracks are by each author
select "Composer" from songs_with_genre_r;

--how many tracks by each author where the genre starts with r
select count("TrackId") as tracks, "Composer" from songs_with_genre_r group by "Composer";



