# Write your MySQL query statement below

/*
OVER(ORDER BY ...) is mandatory when using LAG() or LEAD() because SQL needs a defined order to know which row is “previous” or “next.” Without OVER(ORDER BY ...), the database has no guaranteed row order.
SQL tables are unordered sets by default.
*/

/* id should not change only student should */
select id,
case
    /* we can use aggregates inside when of case eg. when id = count(id) over(partition by id)then.. */
    /* you can use subqueries inside the WHEN clause of a CASE expression, as long as the subquery
    returns a scalar (single) value */
    when id = (select count(id) from Seat) and (select count(id) from Seat) % 2 = 1 then s1.student
    when id % 2 = 1 then s1.next_student
    when id % 2 = 0 then s1.prev_student
end as student
from
(
    /* find next/prev neighbour */
    select id, student, 
    lag(student, 1) over(order by id) as prev_student,
    lead(student, 1) over(order by id) as next_student
    from Seat
) as s1;