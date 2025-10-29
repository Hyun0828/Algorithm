with t as(
    select
        category,
        price,
        product_name,
        row_number() over (partition by category order by price desc) as rn
    from food_product
)
select
    category,
    price as max_price,
    product_name
from t
where rn = 1 and category in ('과자', '국', '김치', '식용유')
order by max_price desc