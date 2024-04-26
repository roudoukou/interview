
# Write your MySQL query statement below

select t1.name, t2.bonus
from Employee as t1
         left join (
    select empId, bonus
    from Bonus
    -- where bonus < 1000
) as t2
                   on t1.empId = t2.empId
where t2.bonus < 1000 or t2.bonus is null;

-- where t1.empId not in (
--     select empId
--     from Bonus
--     where bonus >= 1000
-- )

