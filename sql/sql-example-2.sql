-- update data in table
UPDATE departments
SET departmentName = 'Human Resources'
WHERE departmentName = 'Controlling';
-- delete row from table
DELETE FROM departments
WHERE departmentName = 'Marketing';
-- SQL query examples
SELECT departmentName
FROM departments
WHERE departmentName LIKE 'PR%';
SELECT departmentName
FROM departments
WHERE managerId LIKE '_9004';
SELECT departmentName
FROM departments
WHERE managerId BETWEEN 40000 AND 50000;
SELECT departmentName
FROM departments
WHERE departmentId IN (22, 23);