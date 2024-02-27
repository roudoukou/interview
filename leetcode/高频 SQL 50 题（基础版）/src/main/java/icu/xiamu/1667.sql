
-- 这里调用 right(name, length(name)-1) 反而超时了
select user_id, concat(UPPER(left(name, 1)), lower(substring(name, 2, length(name)))) as name
from Users
order by user_id;