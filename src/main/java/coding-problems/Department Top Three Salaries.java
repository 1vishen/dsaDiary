# Write your MySQL query statement below
/*
ROW_NUMBER(): gives each row a unique sequential number, no ties allowed.
RANK(): ties get the same rank, and the next rank number is skipped.
DENSE_RANK(): ties get the same rank, but numbers never skip.
*/


select d.name as Department, e.name as Employee, e.salary as Salary
from Department d
join Employee e on d.id = e.departmentId
join
(
/* get top 3 salaries in each dept */
select id, salary, dense_rank() over (partition by departmentId 
                            order by salary desc) as rnk
from Employee
/*
Window functions run in the SELECT phase. The WHERE clause happens before SELECT.
That's why we cant do `where rnk <= 3` here cause rnk is not calculated yet
*/
) as rnk_t on rnk_t.id = e.id
where rnk_t.rnk <= 3;