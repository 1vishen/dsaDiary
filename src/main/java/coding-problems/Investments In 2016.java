# Write your MySQL query statement below



/* step 1: separate people that have same tiv_2015 i.e. > 1 when grouped */
with t1 as
        (
                select pid
    from Insurance
            where tiv_2015 in
            (
            select tiv_2015
            from Insurance
            group by tiv_2015
            having count(tiv_2015) > 1
        )
        ),
/* step 2: now we find all unique lat lon */
t2 as
(
        select lat, lon
        from Insurance
                group by lat, lon
                having count(*) = 1
        )

select round(sum(tiv_2016), 2) as tiv_2016
from Insurance
/*
Tuples let you compare multiple columns together, e.g. (a,b) IN (SELECT c,d FROM t).
Use them when checking composite keys, unique pairs, or multi-column membership instead of multiple ANDs.
*/
where pid in (select * from t1) and (lat, lon) in (select * from t2);
