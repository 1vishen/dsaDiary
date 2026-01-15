# Write your MySQL query statement below

/*
Wildcards in SQL are special characters used with LIKE for pattern matching.

%  → Matches zero or more characters (e.g., 'DIAB1%' finds DIAB1, DIAB100, DIAB1234).
_  → Matches exactly one character (e.g., 'DIAB_' finds DIAB1, DIAB2, DIABX).
[] → Matches any single character within the brackets (SQL Server only).
[^]→ Matches any single character not within the brackets (SQL Server only).
In MySQL/PostgreSQL/Oracle, use % and _ most commonly with LIKE.
*/

        select patient_id, patient_name, conditions
from Patients
where conditions like 'DIAB1%'      -- starts at beginning
or conditions like '% DIAB1%';   -- starts after a space
