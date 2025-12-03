# Write your MySQL query statement below

-- we want all persons, even if they have no address, so use LEFT JOIN
select t1.firstname, t1.lastName, t2.city, t2.state from Person t1 
left join Address t2
on t1.personId = t2.personId;