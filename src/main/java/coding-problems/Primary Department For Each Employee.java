# Write your MySQL query statement below

select employee_id, department_id
from 
(
    select employee_id, department_id, primary_flag,
    count(department_id) over(partition by employee_id) as dept_count
    from Employee
) as t
where (dept_count = 1) or (dept_count > 1 and primary_flag = 'Y'); 