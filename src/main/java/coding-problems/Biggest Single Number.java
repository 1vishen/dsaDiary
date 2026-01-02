# Write your MySQL query statement below

select max(t.num) as num
from
        (
                /* get all num with 1 occurance */
                select num
    from MyNumbers
            group by num
            having count(num) = 1
        ) as t;
