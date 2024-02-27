



select customer_id , count(customer_id) as count_no_trans
from Visits
where customer_id in (
    select distinct customer_id
    from Visits
    where visit_id not in
          (select distinct visit_id
           from Transactions)
    );