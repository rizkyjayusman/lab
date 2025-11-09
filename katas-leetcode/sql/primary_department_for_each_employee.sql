SELECT e.employee_id, e.department_id FROM Employee e WHERE e.primary_flag = 'Y'
UNION 
SELECT e.employee_id, e.department_id FROM Employee e 
GROUP BY e.employee_id HAVING COUNT(department_id) = 1 ;