# Write your MySQL query statement below

/* Solution uses a triple self-join on the primary key (id) for O(N) complexity. Since id is indexed, each join lookup (id + 1, id + 2) is nearly instant (O(1)), making the total cost linear to the table size. */

select distinct a.num as ConsecutiveNums
from Logs a
join Logs b on a.id = b.id - 1
join Logs c on a.id = c.id - 2
where a.num = b.num and a.num = c.num;

