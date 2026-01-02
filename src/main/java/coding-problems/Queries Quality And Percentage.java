# Write your MySQL query statement below

/* we can use arithematic, logical, inequality operators inside func like count etc */

/* AGGREGATE LOGIC WITH INEQUALITIES (x < y):
   1. EVALUATION: MySQL turns (x < y) into 1 (True) or 0 (False) per row.
   2. COUNT() TRAP: It counts every "0" as a valid piece of data. Unless the result is NULL,
      COUNT increments, making it useless for conditional counting.
   3. SUM() MECHANIC: It adds the 1s and 0s. Adding 0 does nothing, so it successfully
      filters out False results and only counts the "True" ones.
   4. AVG() MECHANIC: It averages the bitstream (1, 0, 1). This is the "Optimal" way to
      get a percentage without doing (Count/Total) math yourself.
*/

        select query_name, round(avg(rating / position), 2) as quality,
round(sum(rating < 3) / count(rating) * 100, 2) as poor_query_percentage
from Queries q1
group by query_name;
