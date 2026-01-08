# Write your MySQL query statement below

/*
group by alias
SELECT  
  CASE  
    WHEN amount < 100 THEN 'Low spender'  
    WHEN amount BETWEEN 100 AND 200 THEN 'Medium spender'  
    ELSE 'High spender'  
  END AS spending_category,  
  COUNT(*) AS num_customers  
FROM Customer  
GROUP BY spending_category;

Yes, GROUP BY logically happens before SELECT but
When you write GROUP BY spending_category, the database does not literally use the alias. 
It groups by the underlying CASE expression that produces the alias. Most SQL engines 
allow you to reference the alias directly as shorthand.

In MySQL and PostgreSQL, grouping by alias works fine. In stricter engines like SQL Server 
or Oracle, you must repeat the full CASE expression inside GROUP BY.
*/

/* 
if we needed fixed 7 day windows :-
SELECT 
    MAX(visited_on) AS visited_on,
    SUM(amount) AS amount,
    AVG(amount) AS average_amount
FROM Customer
GROUP BY FLOOR(DATEDIFF(visited_on, (SELECT MIN(visited_on) FROM Customer)) / 7)
ORDER BY visited_on;
*/
/* ----- */

/* calc amount for each day, so that for each day if we have multiple customer we dont skip any*/
with daily as
(
    select visited_on, sum(amount) as amount
    from Customer
    group by visited_on
)

/* we need to creats overlapping windows of 7 days for each current day starting from 7th */
select c2.visited_on,
round((
    select sum(c1.amount)
    from daily c1
    where c1.visited_on between date_sub(c2.visited_on, interval 6 day) and c2.visited_on
), 2) as amount,
round((
    select avg(c1.amount)
    from daily c1
    where c1.visited_on between date_sub(c2.visited_on, interval 6 day) and c2.visited_on
), 2) as average_amount
from daily c2
where c2.visited_on >= date_add((select min(visited_on) from Customer), interval 6 day)
order by c2.visited_on;