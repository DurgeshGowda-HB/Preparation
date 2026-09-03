show databases;
use student;
show tables;
select * from stu_info
-- DDL Data Manupulation language
#DML commands is used to mangage and modify the data inside a table
# * It does not chnage the table structure
# * It only works with the data (row/records)

#Generally, DML commands fall into one of four primary categories:
-- 1) INSERT - adds fresh data to a table.
-- 2) UPDATE - Change the data that is already in a table.
-- 3) DELETE - takes a record out of a table.
-- 4) SELECT - Get information out of one or more tables.

-- some few exmaples
#update  
update students
set stu_age = 19
where stu_id = 1;

#delete 
delete from students
where stu_id = 2;

select * from students
where stu_fees < 3000;

#group BY  START 
select stu_class, stu_fees as ttoo
from students
group by stu_class;

SELECT stu_class, SUM(stu_fees) AS tota
FROM students
GROUP BY stu_class;

select stu_fees as sttt
from students 
group by stu_fees;

select stu_age, sum(stu_fees)
from students 
group by stu_age;

# ex1
select stu_class, count(stu_name) as sss
from students 
group by stu_class;

#ex2
select stu_subject, sum(stu_fees) as ttofeeforsub
from students 
group by stu_subject;

#ex3 
select stu_class, avg(stu_age) as avgageofstu
from students
group by stu_class;

#ex4 
select stu_class, max(stu_fees) as maxfees
from students
group by stu_class;

select * from students;

#GROUP  BY ENDS 

#ORDER BY STARTS 
select * from students order by stu_fees asc;

select stu_age from students
order by stu_fees asc;

select stu_age from students
order by stu_fees desc;

#order by ends 

# having clause 
SELECT stu_subject, COUNT(stu_name) AS FRG 
FROM students 
where stu_age > 16
GROUP BY stu_subject
having stu_age > 16;

select stu_subject, count(*) as num_students
from students
group by stu_subject 
having count(*) > 0;

#limit 
select stu_name from students
limit 4;
