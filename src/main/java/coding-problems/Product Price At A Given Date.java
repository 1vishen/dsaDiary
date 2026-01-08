# Write your MySQL query statement below

/*
can i do arithematic/inequalities inside aggregate func??

Yes, you can perform arithmetic expressions inside aggregate functions.
No, you cannot directly put inequalities, You need to filter rows first using WHERE or CASE, then apply the aggregate:
eg. SELECT MAX(change_date) AS latest_date
FROM Products
WHERE change_date <= '2019-08-16';
*/

select p2.product_id,
/* if the subquery finds no rows (meaning no changes before 2019‑08‑16), it returns NULL, COALESCE replaces that with the default price 10. */
coalesce
(
   ( /* sorting by product id as asc but within each product id i need date to be sorted as desc */
    select p1.new_price
    from Products p1
    /* this gives a list of rec only for one product id each time so that limit can do its job */
    where p1.product_id = p2.product_id and p1.change_date <= '2019-08-16'
    /* sorting by product id as asc but within each product id i need date to be sorted as desc */
    order by p1.product_id asc, p1.change_date desc
    /* in order for this limit to work for each product id instead of full table we need to correlate
    this inner query with outer */
    limit 1), 10
) as price
from 
(
    select distinct product_id from Products
) as p2;


