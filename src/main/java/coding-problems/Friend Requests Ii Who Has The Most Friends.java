# Write your MySQL query statement below

/* count max in both req and acc id them join them, summing them while joining */
/*
- In MySQL, you can’t stack WITH clauses like that. You need a single WITH and then list multiple CTEs separated by commas.
*/
with t1 as
        (
                select requester_id as id1, count(requester_id) as counts1
from RequestAccepted
group by requester_id
),
t2 as
        (
                select accepter_id as id2, count(accepter_id) as counts2
from RequestAccepted
group by accepter_id
)
/*
Yes, you absolutely can use columns from one CTE inside another. That’s one of the main advantages of CTEs: they let you build queries step by step, reusing results from earlier definitions. Later CTEs can reference earlier ones, but not the other way around.
*/

/*
union in sql:-
1. Each SELECT must return the same number of columns.
2. Column order must align positionally across all SELECTs.
3. Data types must be compatible (cast if needed).
4. Final column names come from the first SELECT only.
*/

        /* UNION in SQL just stacks two result sets vertically into one combined table. */
        select id, sum(counts) as num
from
        (
                select id1 as id, counts1 as counts from t1
                union all
                select id2 as id, counts2 as counts from t2
        ) as t
group by id
order by num desc
limit 1;

