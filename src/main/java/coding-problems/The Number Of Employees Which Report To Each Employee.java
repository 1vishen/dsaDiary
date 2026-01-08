# Write your MySQL query statement below

/* 2nd part, find the remaining info of the list of managers i found */

select e.employee_id, e.name, m.emp_under_mgr as reports_count, m.emp_avg_age as average_age
from Employees e
join
(
    /* 1st part, find all managers */
    select reports_to as manager_id, count(employee_id) as emp_under_mgr,
    round(avg(age), 0) as emp_avg_age
    from Employees
    where reports_to is not null
    group by reports_to
) as m
on e.employee_id = m.manager_id
order by e.employee_id asc;