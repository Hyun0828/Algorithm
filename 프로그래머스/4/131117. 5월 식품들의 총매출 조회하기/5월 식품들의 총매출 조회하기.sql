with t as (
    select product_id, sum(amount) as amount
    from food_order
    where produce_date >= '2022-05-01' and produce_date < '2022-06-01'
    group by product_id
)
select
    p.product_id,
    p.product_name,
    t.amount * p.price as total_sales
from food_product p
join t on p.product_id = t.product_id
order by total_sales desc, p.product_id