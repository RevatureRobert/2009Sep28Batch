select * from "Track";
select * from "Album" where "ArtistId" is null;
select * from "Artist";
----JOINS
--joins will bring tables together at the columns.
select * from "Track" join "Genre" on "Track"."GenreId" = "Genre"."GenreId";
select "Track"."Name", "Genre"."Name" from "Track" join "Genre" on "Track"."GenreId" = "Genre"."GenreId";

--different types of joins
----inner join, outer join (left outer, right outer, full outer), self, cross, cartesian

--inner join
select * from "Track" join "Album" on "Track"."AlbumId" = "Album"."AlbumId";
select * from "Track" inner join "Album" on "Track"."AlbumId" = "Album"."AlbumId";

--right outer
select * from "Album" right join "Artist" on "Album"."ArtistId" = "Artist"."ArtistId";

--left outer
select * from "Album" left join "Artist" on "Album"."ArtistId" = "Artist"."ArtistId";

--full outer
select * from "Album" full join "Artist" on "Album"."ArtistId" = "Artist"."ArtistId";

--some different ways to write inner joins
select * from "Album" a join "Artist" b on a."ArtistId" = b."ArtistId"; 
select * from "Album"a, "Artist"b where a."ArtistId" = b."ArtistId";

-- self join
select * from "Album"a, "Album"b where a."AlbumId" = b."AlbumId";

-- cross join
select * from "Album"a cross join "Artist"b;
select count("AlbumId") from "Album";
select count("ArtistId") from "Artist";
select count("AlbumId") from "Album" a cross join "Artist"b;

--set operators
----brings tables together at the rows
----union, union all, intersect, and minus
----all set operators follow two rules:
------the operation must work with the same datatypes and the same number of columns

create table a (
	number_a integer
);

create table b (
	number_b integer,
	string text
);

insert into a values (1),(2),(3);
insert into b values (2,'hey'),(3,'look'), (4, 'amee');

--union
select * from a union select number_b from b;
select * from a union distinct select number_b from b;

--union all
select number_a as num from a union all select number_b from b;

--intersect
select * from a intersect select number_b from b;

--minus (keyword does not work, use except)
select * from a except select number_b from b;
