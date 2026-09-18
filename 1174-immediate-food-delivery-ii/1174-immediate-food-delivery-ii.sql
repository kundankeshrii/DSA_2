select round(
        avg(d.order_date=d.customer_pref_delivery_date)
        *100,2) as immediate_percentage 
from delivery d
join (
    select customer_id,min(order_date) as first_order
    from delivery 
    group by customer_id
) as t
on d.customer_id=t.customer_id
and d.order_date=t.first_order
;

