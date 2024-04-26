-- # Write your MySQL query statement below

select unique_id, name
from Employees e join EmployeeUNI eu
                      on e.id = eu.id

union all

select NULL as unique_id , name
from Employees
where id not in (
    select id from EmployeeUNI
);

-- 傻乎乎的用的union all连接的, 才发现直接可以用right join

select unique_id , name
from EmployeeUNI as Eu
RIGHT JOIN Employees as E
on Eu.id = E.id;