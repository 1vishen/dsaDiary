# Write your MySQL query statement below

/*
If you want to count all rows → use COUNT(*).
If you  want to count only non‑null values in a specific column → use COUNT(column).
*/

/*
**Alias inside `SELECT`**
```sql date_add(a.first_login, interval 1 day) as next_login```
`first_login` is an alias you’re defining in the same `SELECT`.  
You cannot reference an alias (`a.first_login`) in another expression in the same `SELECT`.  
You must compute `MIN(a.event_date)` first, then use it in an outer query.

---

Aggregates like MIN, MAX, SUM cannot be mixed with raw columns in the same query.  
Compute them first in a subquery/CTE, then join back to the base table.  
Raw columns and simple expressions (e.g. DATE_ADD(event_date, INTERVAL 1 DAY)) are safe directly.  
Rule of thumb: calculate aggregates separately, then reference them in joins or filters.  
*/

with login_t as 
(
select a.player_id
from Activity a
join
    (
    select player_id, min(event_date) as first_login
    from Activity
    group by player_id
    ) as b
/* means for same player id does next day exists? */
on a.player_id = b.player_id and
    a.event_date = date_add(b.first_login, interval 1 day)
)

/*
GROUP BY changes the scope of aggregation.  
Without `GROUP BY`, aggregates (`MIN`, `MAX`, `COUNT`, `SUM`, etc.) apply to the **whole table**.  
With `GROUP BY`, aggregates apply **inside each group**.
*/

/*
GROUP BY collapses rows into one per group, so non‑aggregated columns must be grouped or aggregated; OVER … PARTITION BY keeps all rows and attaches aggregates alongside them, letting you mix both safely.
*/

select cast(
            count(distinct lt.player_id) / 
            (
            select count(distinct player_id) from Activity
            )
        as decimal(4,2)) as fraction
from login_t lt;


