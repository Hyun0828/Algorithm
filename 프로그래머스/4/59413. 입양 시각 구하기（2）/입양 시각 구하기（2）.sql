with recursive t as (
    select 0 as hour
    
    union all
    
    select hour+1 from t where hour < 23
)
select
    t.hour,
    count(animal_id) as count
from t
left join animal_outs o on t.hour = hour(o.datetime)
group by t.hour
order by t.hour

