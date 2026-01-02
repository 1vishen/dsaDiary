# Write your MySQL query statement below

select s1.product_id, s1.year as first_year, s1.quantity, s1.price
from Sales s1
join
        (
                /* get first year per product */
                select min(year) as minyear, product_id
from Sales
group by product_id
) as s
on s1.year = s.minyear and s1.product_id = s.product_id;
