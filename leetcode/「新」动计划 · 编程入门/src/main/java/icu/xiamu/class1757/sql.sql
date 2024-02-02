-- https://leetcode.cn/problems/recyclable-and-low-fat-products/?envType=study-plan-v2&envId=primers-list

select product_id
from Products
where low_fats = 'Y'
and recyclable = 'Y'