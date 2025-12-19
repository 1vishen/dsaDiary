# Write your MySQL query statement below

/* since we need to join every rec, we need left outer join */
select e.name, b.bonus
from Employee e
left join Bonus b
on e.empId = b.empId
where b.bonus < 1000 or b.bonus is null;