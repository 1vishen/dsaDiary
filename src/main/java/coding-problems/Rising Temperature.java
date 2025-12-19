# Write your MySQL query statement below

/*
-- DATE_ADD(): adds a time interval to a date → DATE_ADD(date, INTERVAL value unit)
-- DATE_SUB(): subtracts a time interval from a date → DATE_SUB(date, INTERVAL value unit)
-- DATE_FORMAT(): formats a date/time into a custom string → DATE_FORMAT(date, 'format_string')
*/

/* we cannot alias inside ON clause */

select w1.id
from Weather w1
join Weather w2
/* here w2.recordDate becomes earlier data and w1.recordDate becomes currentdate*/
on w1.recordDate = date_add(w2.recordDate, interval 1 day)
where w1.temperature > w2.temperature;


