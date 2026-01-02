# Write your MySQL query statement below

/* WHERE filters rows; HAVING filters groups. */

select class
from Courses
                group by class
having count(student) >= 5;
