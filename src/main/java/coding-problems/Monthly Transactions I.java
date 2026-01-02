# Write your MySQL query statement below

/* we can use extract() to get y,m,d,time etc */
/* when using inequalities count() doesnt work as expected so we use sum() which works like count() */
/* we can use case inside aggreagte func */
/* Y for 4 digit year y for 2 digit etc. */
select date_format(trans_date, '%Y-%m') as month,
country, count(state) as trans_count,
sum(state = 'approved') as approved_count, sum(amount) as trans_total_amount,
sum(case when state = 'approved' then amount else 0 end) as
approved_total_amount
from Transactions
group by month, country;
