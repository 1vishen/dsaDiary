# Write your MySQL query statement below

/*
we can use a offset parameter 'n' within LAG(col, n) or LEAD(col, n) to retrieve values from n rows away relative to the current row's position, however not needed here cause
we are using alternative approach where we dont need to align specific rec of a col
to each other cause we are using AVG() function and when we select start/end we are 100% sure they are the same machine and same task because of the ON clause
*/

/*
The AVG() function computes the mean by internally summing values and dividing by the count of non-null entries within each GROUP BY partition.
*/

select a.machine_id, cast(avg(b.timestamp - a.timestamp) as decimal(10,3)) as
        processing_time
from Activity a
join Activity b
on a.machine_id = b.machine_id and a.process_id = b.process_id
where a.activity_type = 'start' and b.activity_type = 'end'
/* problem asks for the average time per machine. To get that, you must group only by machine_id */
group by a.machine_id;

