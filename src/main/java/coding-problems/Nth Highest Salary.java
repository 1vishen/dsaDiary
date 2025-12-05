CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
    /* we must use a pre-calculated variable for the `OFFSET` value because MySQL 
    does not allow the expression `N - 1` in that clause. The `DECLARE` and `SET` 
    statements must be placed directly after `BEGIN` and before `RETURN`. */

    declare offset_val int;
    set offset_val = N - 1;

  RETURN (
      # Write your MySQL query statement below.

      /* The inner SELECT forms a temporary table, and AS t names it so the outer 
      query can use it.
      A derived table must place its alias immediately after the closing ')', and SQL
      allows only one FROM, so writing '() from t' is invalid syntax. */

      /* Use scalar subqueries only when a single value is expected; use multi-row 
      subqueries in list/table contexts like IN, EXISTS, or FROM(...). If a multi-row 
      subquery is placed where a scalar is required, SQL raises “subquery returns 
      more than 1 row.” */

      select t.salary from 
      (select distinct salary from Employee 
      order by salary desc limit 1 offset offset_val) 
      as t

  );
END