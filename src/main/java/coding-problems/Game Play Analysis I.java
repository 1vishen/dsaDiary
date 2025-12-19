# Write your MySQL query statement below

/*
only the columns explicitly listed in the subquery's SELECT statement exist in that temporary table, so we need to mention all cols we need to use in subquery' select.
*/

select a.player_id, t.event_date as first_login
from Activity a
join 
(
select player_id, event_date, 
        row_number() over (partition by player_id order by event_date asc)
        as event_date_rnk
from Activity
) as t
/*
on a.player_id = t.player_id
Since the Activity table has multiple rows per player, and our temporary table t also contains multiple rows per player (one for every event date), this join creates a massive Cartesian Product for every player group.
*/
on a.player_id = t.player_id and a.event_date = t.event_date
where t.event_date_rnk = 1;
