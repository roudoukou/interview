
-- select id, email
-- from Person
-- where

select p1.id
from Person p1, Person p2
where p1.id != p2.id and p1.email = p2.email;