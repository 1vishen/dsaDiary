# Write your MySQL query statement below

select s.user_id, cast(ifnull(t.final, 0) as decimal(10,2)) as confirmation_rate
from Signups s
left join
        (
                select c1.user_id,
    (
                select count(c2.action) as cnf
from Confirmations c2
/* 1st we need to find no of messages and confirmed messages, if we want
subuqery to behave as correlated subquery i.e. run 1-on-1 with outer query we
need to connect it to outer query otherwise it will return multiple rows and
error will occur */
where c2.user_id = c1.user_id and c2.action = 'confirmed'
        /* - NULL appeared because GROUP BY on an empty set returns "no rows," which
            the outer query interprets as NULL.
        - Without GROUP BY, aggregate functions (like COUNT) always return
            exactly one row (0) even if the input set is empty.
        */
        -- group by user_id, action
    ) / count(*) as final
from Confirmations c1
group by user_id
) as t
on s.user_id = t.user_id;
