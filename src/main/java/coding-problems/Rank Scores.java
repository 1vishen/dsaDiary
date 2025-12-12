# Write your MySQL query statement below

/* for each score we can count how many distinct scores are strictly greater than it then the rank of that score is simply that count + 1. using `rank` cause rank
is reserved in mysql */

select a.score as score, (select count(distinct b.score)
                            from Scores b
                            where b.score > a.score ) + 1 as `rank`
from Scores a
order by a.score desc; 
