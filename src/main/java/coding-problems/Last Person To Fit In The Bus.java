# Write your MySQL query statement below


select person_name
from Queue q2
join
(
    /* Aggregate functions collapse rows into a single result per group (e.g. SUM(weight)).
    Window functions preserve each row, adding an aggregate over a moving "window".
    OVER (ORDER BY turn) produces a cumulative sum row by row, not one grand total.
    Use aggregates for overall totals, window functions for running or per-row context.
    The window expands dynamically as the query advances, updating continuously like an incremental
    sum. */
    select q1.person_id, sum(weight) over(order by turn) as curr_weight
    from Queue q1
    order by turn
) as q1
on q2.person_id = q1.person_id
/*
WHERE filters rows before grouping, so only row-level expressions are valid there.
Aggregates like SUM/AVG are computed after GROUP BY (so can't be used in WHERE),
making them usable in HAVING, SELECT, or ORDER BY clauses.
Window functions are evaluated after WHERE/GROUP BY/HAVING but before ORDER BY/LIMIT,
as part of SELECT-list processing, producing per-row values usable in SELECT and ORDER BY.
Key rule: row filters → WHERE, group filters → HAVING, per-row aggregates → window functions.
*/
where q1.curr_weight <= 1000
/* limit, offset only accept int 
limit count(q1.person_name) offset count(q2.person_name - 1) */
order by q1.curr_weight desc
limit 1;
