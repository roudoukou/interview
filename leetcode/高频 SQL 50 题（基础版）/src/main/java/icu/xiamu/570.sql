# Write your MySQL query statement below

select name
from Employee t1, (
    select managerId, count(managerId) as managerId_count
    from Employee
    group by managerId
    having managerId_count >= 5
) t2
where t1.id = t2.managerId;

