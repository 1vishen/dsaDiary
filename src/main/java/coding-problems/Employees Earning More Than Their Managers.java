# Write your MySQL query statement below

-- SQL allows using b.name in JOIN/WHERE without selecting it in output (in SELECT clause)

select a.name as Employee
from Employee a
join Employee b
on a.managerId = b.id
where a.salary > b.salary;
