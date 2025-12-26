# Write your MySQL query statement below

/* we join examinations and students table with student_id col from students table
cause we need each student even if they attended 0 examinations, similarly subject_name from su table cause we need all subjects even if student didnt attend it we cant have
null in any subjects */

select s.student_id, s.student_name, su.subject_name,
/* count(*) will count null as 1 so students who didnt attend a subj exam will also be counted as 1, so we need to count something else, if we give a col name in count()
it ignores null so we give it e.student_id cause it represents which stu has attended which exam and when it will be null (cause left join) it will be counted as 0 */
count(e.student_id) as attended_exams
from Students s
/* we need all subjects for all students to be represented so a cross join is needed,
not full outer but cross join cause we need combination of each student with each subject */
cross join Subjects su
/* join this cross join result to examinations table */
left join Examinations e on e.student_id = s.student_id and
e.subject_name = su.subject_name
group by s.student_id, su.subject_name
order by s.student_id, su.subject_name;
