select f.food_type, f.rest_id, f.rest_name, f.favorites
from rest_info f
join (
    select food_type, max(favorites) as favorites
    from rest_info
    group by food_type
) r on f.favorites = r.favorites and f.food_type = r.food_type
order by f.food_type desc
