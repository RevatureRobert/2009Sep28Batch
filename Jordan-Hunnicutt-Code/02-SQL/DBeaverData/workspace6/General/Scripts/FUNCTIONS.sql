--different types of functions
--aggregate and scalar

----aggregate works with multiple values
-------count, avg, sum
----scalar works with singular
-------floor, ceiling, round, abs

--aggregate function works with multiple values
select count("TrackId") from "Track";
select count("TrackId") as how_many_tracks_start_with_r_for_its_genre from songs_with_genre_r;

--scalar functions work with single values
select abs(-100);

--this statement gives many duplicates, which makes it hard to tell how many songs by each composer
select "Composer" from songs_with_genre_r;

--how many tracks by each composer where the genre starts with r
select count("TrackId")as tracks, "Composer" from songs_with_genre_r group by "Composer";