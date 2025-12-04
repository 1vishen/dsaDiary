# Write your MySQL query statement below

-- Alias alone only renames a column; to return a single scalar value (or NULL when no row exists), we must wrap the query in a subquery.
-- SELECT DISTINCT ... LIMIT/OFFSET returns a result set, but LeetCode requires exactly one value, so a scalar subquery is mandatory.

select (select distinct salary from Employee 
order by salary desc 
limit 1 offset 1) as SecondHighestSalary;