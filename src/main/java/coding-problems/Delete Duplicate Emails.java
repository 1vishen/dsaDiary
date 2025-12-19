# Write your MySQL query statement below

with rankedTable as (
/* partitioned by email and assigned rank to each dup */
select id, email, dense_rank() over 
                        (partition by email order by id asc) as rnk
from Person p
)

/* cant delete from subquery (derived table) or CTE in mysql */
delete from Person
where id in (select id from rankedTable where rnk > 1);
