# Write your MySQL query statement below

/*
WHERE filters rows before they are grouped, HAVING filters groups after they are counted
*/

select email as Email
from Person
group by email
having count(email) > 1;
