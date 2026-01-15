# Write your MySQL query statement below

/*
UPPER()     → Converts all characters in a string to uppercase.
LOWER()     → Converts all characters in a string to lowercase.
SUBSTRING() → Extracts part of a string starting at a given position for a given length.
LEFT()      → Returns the leftmost N characters from a string.
RIGHT()     → Returns the rightmost N characters from a string.
CHARINDEX() → Finds the position of a substring within a string (SQL Server; use INSTR in MySQL/Oracle).
CONCAT()    → Joins two or more strings together into one.
LENGTH()        -- returns number of bytes
CHAR_LENGTH()   -- returns number of characters
*/

        select user_id, concat(upper(substring(name, 1, 1)), lower(substring(name, 2, length(name)))) as name
from Users
order by user_id;



