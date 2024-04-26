# Write your MySQL query statement below

select w2.id as Id
from Weather w1 , Weather w2
where w1.recordDate + INTERVAL 1 DAY = w2.recordDate
  and w2.Temperature > w1.Temperature;