# Write your MySQL query statement below

/*
INTERVAL in MySQL represents a time duration (days, months, years, hours, etc.)
used with date/time arithmetic functions like DATE_ADD, DATE_SUB, or directly in expressions.
*/

select activity_date as day, count(distinct user_id) as active_users
from Activity
where (activity_date > '2019-07-27' - interval 30 day) and (activity_date <= '2019-07-27')
group by activity_date;
