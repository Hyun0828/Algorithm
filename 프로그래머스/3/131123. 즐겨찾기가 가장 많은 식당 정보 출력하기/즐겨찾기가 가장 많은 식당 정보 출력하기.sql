with t as (
    select
        food_type,
        rest_id,
        rest_name,
        favorites,
        row_number() over (partition by food_type order by favorites desc) as rn
    from rest_info
)
select
    food_type, rest_id, rest_name, favorites
from t
where rn = 1
order by food_type desc