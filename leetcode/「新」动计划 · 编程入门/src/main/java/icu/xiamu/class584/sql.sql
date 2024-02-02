-- https://leetcode.cn/problems/find-customer-referee/submissions/500168518/?envType=study-plan-v2&envId=primers-list

select name from Customer
where referee_id != 2 or referee_id is null