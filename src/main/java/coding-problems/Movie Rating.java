# Write your MySQL query statement below

/*
The USING clause in SQL is a shorthand for specifying join conditions when both tables share a column with the same name.
SELECT *
FROM A
JOIN B ON A.id = B.id;
SELECT *
FROM A
JOIN B USING (id);
*/

select t1.name as results
from
(
    /* find user with highest reviews */
    select u.name
    from MovieRating m
    left join Users u on m.user_id = u.user_id 
    group by u.name
    /* since ques says lexicographically smaller, counts desc and inside those counts, name asc */
    order by count(m.user_id) desc, u.name asc
    limit 1
) as t1

union all

select t2.title
from
(
    /* find the movie with highest avg rating */
    select mo.title
    from MovieRating m
    left join Movies mo on m.movie_id = mo.movie_id
    where month(m.created_at) = 2 and year(m.created_at) = '2020'
    group by mo.title
    order by avg(m.rating) desc, mo.title asc
    limit 1
) as t2;