#SQL clauses

use student;
show tables;
CREATE TABLE students (
    stu_id INT PRIMARY KEY,
    stu_name VARCHAR(50),
    stu_fees INT,
    stu_subject VARCHAR(50),
    stu_age INT,
    stu_class INT
);
INSERT INTO students VALUES
(1, 'Divyesha Patil', 3000, 'Maths', 16, 10),
(2, 'Mayra Pandit', 2000, 'Social Science', 15, 10),
(3, 'Kunal Purohit', 4500, 'Chemistry', 17, 11),
(4, 'Manvi Tyagi', 2000, 'Social Science', 16, 9),
(5, 'Joy Yadav', 3000, 'Maths', 16, 9),
(6, 'Tisha Shah', 2500, 'Science', 15, 9),
(7, 'Surbhi Soni', 4000, 'Chemistry', 17, 10);

select * from students;

--Example 1: Using the WHERE Clause

select * from students
where stu_fees<3000;

--Example 2: Using the GROUP BY Clause--

select stu_class, sum(stu_fees) as total_fees
from students
group by stu_class;

select stu_class, sum(stu_fees) as tt
from students
group by stu_class;

--#more group by examples
--#write a query to find the total number of students in each class.
select stu_class, count(stu_name) as total_stu
from students
group by stu_class;


select stu_class, count(stu_fees) as total
from students
group by stu_class;

--#Write a query to find the total fees collected for each subject.
select stu_subject, sum(stu_fees) as collected_from_each
from students
group by stu_subject;

select * from students;

--#Write a query to find the average age of students in each class
select stu_class, avg(stu_age) as avgage
from students
group by stu_class;

--#Write a query to find the maximum fees paid in each class.
select stu_class, max(stu_fees) as max_fee
from students
group by stu_class;

select * from students;
--#Write a query to count how many students are 
--#there in each subject where age is greater than 15.

select stu_subject, count(stu_name >15) as total
from students
group by stu_subject;

--Example 3: Using the ORDER BY Clause--

select from student
oredr by stu_age asc --or desc

--Example 4: Using the HAVING Clause--

#having 

select city, count(*) as nnnn
from employee
group by city
having count(EmpName) > 3;
-- Show cities having more than 3 employees

select department, count(EmpName) as total_emp_in_depart 
from employee
group by department
having count(EmpName) > 3;
-- Show departments having more than 3 employees
  

--display city where total salary > 200000

select city, sum(salary) as totoalcsalary
from employee 
group by city 
having totoalcsalary > 200000;
-- Show cities where total salary is greater than 200000


-- Show departments where average salary is greater than 60000
select department, avg(salary) as vv
from employee
group by department
having vv > 60000;
-- Departments with average salary greater than 60000


--Display cities where minimum salary is less than 30000
select city, min(salary) as ss
from employee
group by city 
having ss < 30000;
-- Cities where minimum salary is less than 30000


# show dept having exactly 3 employees
select department, count(EmpName) as qq
from employee
group by department
having qq = 3;
-- Departments having exactly 3 employees


select * from employee;
-- Display all employee records

truncate employee;
-- Remove all records from employee table (structure remains)

update employee set department = "IA"
where EmpID = 1;
-- Update department of employee with EmpID = 1

START TRANSACTION;
-- Start a new transaction

delete from employee 
where EmpId = 1;
-- Delete employee with EmpID = 1

rollback;
-- Undo the delete operation if not committed
--Example 5: Using the LIMIT Clause--

SELECT stu_name, stu_fees
FROM Students
ORDER BY stu_fees DESC
LIMIT 3;

--Example 6: Using the FROM Clause--

select stu_class
from students;

--Example 7: Using the LIKE Operator--

--The LIKE operator is used within a WHERE clause to search for
--a specified pattern in a column. It is typically used with wildcards such as:

"%" : matches zero or more characters
"_" : matches a single character

SELECT stu_name, stu_subject FROM 
Students_Table WHERE stu_name LIKE '%Patil';
Output:

stu_name            stu_subject
Divyesha Patil      Maths

--Example 8: Using the AND Operator--

--The AND logical operator combines multiple conditions 
--in a WHERE clause, and a record is only included if all conditions are true.

Query:

SELECT stu_name, stu_class, stu_age 
FROM Students_Table WHERE stu_class = 9 AND stu_age = 16;

--Example 8: Using the OR Operator--

--The OR clause is used to combine multiple conditions
--where at least one must be true. It is useful when searching for multiple criteria,
--such as retrieving customers from either New York or Los Angeles.


