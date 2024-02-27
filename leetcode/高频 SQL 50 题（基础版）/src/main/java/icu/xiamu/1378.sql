
select e1.id , unique_id
from Employees e1 left join EmployeeUNI e2
on e1.id = e2.id;
