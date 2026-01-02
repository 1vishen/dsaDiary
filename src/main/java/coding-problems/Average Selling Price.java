# Write your MySQL query statement below

/*
Question: but if group by is destructive and select runs after group by how can aggreagte func look into window, it should be gone right? replaced by 1 row?

    - Aggregates (SUM/COUNT) act as reducers during the GROUP BY phase,
     processing row "buckets" before they are collapsed into a single result.
    - Window functions (OVER) execute after this collapse, meaning they
     only see the final summarized rows and cannot "reach back" to the
     original granular data.
*/

/*
Question: okay but i dont understand 1 thing how sum work?
when i did sum(p.price * u.units) it multiplied each rec of price to units 1 by 1 but when i did sum(u.units) it added all in units col vertically? why 2 different behaviours of sum?

   - Expression evaluation: SQL first calculates 'price * units' horizontally
     for every individual row within the group (Scalar math).
   - Vertical Aggregation: After calculating those row-level products,
     the SUM function then adds those results together vertically.
   - This ensures correct revenue calculation (sum of products) rather
     than just multiplying the totals of each column.

    all aggregate functions work the exact same way. Whether it is SUM, AVG, MIN, MAX, or COUNT, SQL always follows the same two-step rule:
    Horizontal First: Evaluate the expression inside the parentheses for every single row in the group.
    Vertical Second: Apply the aggregate logic (adding, averaging, finding the highest, etc.) to those resulting values.
*/

/*
- Comparison: COALESCE(a, b, c) is functionally equivalent to nested IFNULL(a, IFNULL(b, c)).
   - Readability: COALESCE avoids the "Pyramid of Doom" (excessive nesting) by providing a flat, readable list of priority fallbacks.
   - Portability: COALESCE is ANSI SQL standard (works in Postgres, SQL Server, Oracle), whereas IFNULL is largely specific to MySQL/SQLite.
   - Efficiency: It uses short-circuit evaluation, returning the first non-null value
     and ignoring the rest of the arguments.
*/

select p.product_id, coalesce(round(sum(p.price * u.units) / sum(u.units), 2), 0) as average_price
from Prices p
left join UnitsSold u
/* joining on pruchase date b/w start and end is imp cause prices change */
on p.product_id = u.product_id and (u.purchase_date between p.start_date and p.end_date)
/* if you use GROUP BY p.product_id without any aggregate functions (like SUM or COUNT), MySQL is forced to "collapse" all the rows for that ID into a single row. Because you didn't tell it how to combine the numbers (e.g., "add them" or "average them"), it simply picks the first row it encounters for that ID and discards the rest. */
group by p.product_id;

