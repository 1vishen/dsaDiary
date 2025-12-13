# Write your MySQL query statement below

/* find all employees who's salary matches max we found in subquery */
select d.name as Department, e.name as Employee, e.salary as Salary
from Department d
join Employee e
on d.id = e.departmentId
where e.salary = 
(
/* for every employee find max salary in their dept */
select max(salary) 
from Employee
where departmentId = e.departmentId
);
