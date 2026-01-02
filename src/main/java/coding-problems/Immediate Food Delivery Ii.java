# Write your MySQL query statement below
/*
When you use GROUP BY, every column in your SELECT list must be:
- Part of the GROUP BY clause, OR
- Wrapped in an aggregate function (MIN, MAX, SUM, COUNT, AVG, etc.).
If you don’t do this, SQL doesn’t know which value to pick for that column within the group, because grouping collapses multiple rows into one.
*/

select cast(sum(t2.order_type = 'immediate') /
count(t2.order_type) * 100
as decimal(10,2)) as immediate_percentage
from
        (
                /* 1st we label immediate orders */
                select case
                when t.min_order = d2.customer_pref_delivery_date
                then 'immediate' else 'scheduled'
                end as order_type
                from Delivery d2
                join
                (
        /* it will only select min order date within
        each cust_id grp, also cant include delivery_id for joining
        later cause its not aggregated nor grouped */
                select customer_id, min(order_date) as min_order
from Delivery
group by customer_id
    ) as t
/* we need min order to match its own rec's pref delivery date
if we want to use it in case later */
on d2.customer_id = t.customer_id and d2.order_date = t.min_order
) as t2;
