# Write your MySQL query statement below

/* 
whats wrong here? 
The CASE expression buckets incomes into salary ranges, and GROUP BY only forms groups that exist in the data. If no row falls into "Average Salary," that group isn’t created, so COUNT(*) skips it. SQL doesn’t auto‑generate groups for missing categories.

select
case
    when income < 20000 then "Low Salary"
    when income >= 20000 and income <= 50000 then "Average Salary"
    when income > 50000 then "High Salary"
end as category,
tried doing both coalesce and count :-
1. coalesce(count(account_id), 0) as accounts_count
2. count(*) as accounts_count
from Accounts
group by category;
*/

/* how do we select cols that don't exist?
In SQL you can’t directly “select” a column that doesn’t exist in the table — the engine will throw an error. But you can create synthetic columns in your result set by using constants, expressions, or CASE logic. That’s how you force categories or labels to appear even if no rows naturally produce them.
*/

select t1.category, count(a.account_id) as accounts_count
from
(
    select 'Low Salary' as category
    /* UNION removes duplicate rows including identical NULLs, while UNION ALL keeps all rows and 
    NULLs. */
    union all
    select 'Average Salary' as category
    union all
    select 'High Salary' as category
) as t1
left join Accounts a
/* 
JOIN conditions are not limited to t1.col1 = t2.col2. 
They can use any logical expression (>, <, BETWEEN, OR, AND). 
This allows flexible joins like matching categories to ranges of values. 
Your example is valid because it joins on conditional logic instead of strict equality. 
*/
on (t1.category = 'Low Salary' and a.income < 20000) or 
   (t1.category = 'Average Salary' and (a.income >= 20000 and income <= 50000)) or 
   (t1.category = 'High Salary' and a.income > 50000)
group by t1.category;