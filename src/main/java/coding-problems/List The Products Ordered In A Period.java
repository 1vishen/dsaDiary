# Write your MySQL query statement below

select p.product_name, sum(o.unit) as unit
from Orders o
left join Products p
on o.product_id = p.product_id
where month(o.order_date) = 2 and year(order_date) = 2020
group by p.product_name
having sum(o.unit) >= 100;
