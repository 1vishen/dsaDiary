# Write your MySQL query statement below

/*
GROUP_CONCAT is a MySQL aggregate function that combines values from multiple rows
into a single string, often used with GROUP BY to list items per group.
GROUP_CONCAT([DISTINCT] expr
             [ORDER BY expr ASC|DESC]
             [SEPARATOR str])
You can control
ordering (GROUP_CONCAT(product ORDER BY product ASC)),
separators (GROUP_CONCAT(product SEPARATOR ';')), and
distinctness (GROUP_CONCAT(DISTINCT product)).

Syntax pattern:
SELECT grouping_column,
       GROUP_CONCAT(target_column ORDER BY target_column ASC SEPARATOR ',') AS bucket
FROM table_name
GROUP BY grouping_column;

- grouping_column → decides how rows are bucketed (e.g., sell_date, sell_date2, price).
- target_column → decides what values get concatenated (e.g., product).
*/

select a2.sell_date, a2.num_sold, group_concat(distinct product order by product asc) as products
from Activities a1
join
        (
                /* group no of products sold by date */
                select sell_date, count(distinct product) as num_sold
from Activities
group by sell_date
) as a2
on a2.sell_date = a1.sell_date
group by a2.sell_date
order by a2.sell_date;
