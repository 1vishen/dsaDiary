# Write your MySQL query statement below

/* need to show id for every employee even if its null i.e. left outer join */

select b.unique_id, a.name
from Employees a
left join EmployeeUNI b
on a.id = b.id;
