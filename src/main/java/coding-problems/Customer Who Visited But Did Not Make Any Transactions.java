# Write your MySQL query statement below

        /* now we find all customers who visited not made trans */
        select customer_id, count(customer_id) as count_no_trans
from Visits
where visit_id not in
        (
                /* find all visit_id that have visited and made trans */
                select distinct visit_id
                from Transactions
        )
group by customer_id;
