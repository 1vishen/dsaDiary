# Write your MySQL query statement below

select a.name
from Employee a
join
(
    select managerId
    from Employee
    group by managerId
    having count(managerId) >= 5
) as b
on a.id = b.managerId;