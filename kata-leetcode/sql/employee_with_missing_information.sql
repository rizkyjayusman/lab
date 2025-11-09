select e.employee_id employee_id from Employees e LEFT JOIN Salaries s on s.employee_id = e.employee_id WHERE s.employee_id is null 
UNION 
select s.employee_id employee_id from Employees e RIGHT JOIN Salaries s on s.employee_id = e.employee_id WHERE e.employee_id is null 
ORDER BY employee_id ;