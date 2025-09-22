with g1 as (
    select id
    from ecoli_data
    where parent_id is null
),
g2 as (
    select ecoli_data.id
    from ecoli_data
    join g1 on ecoli_data.parent_id = g1.id
)
select ecoli_data.id
from ecoli_data
join g2 on ecoli_data.parent_id = g2.id
order by ecoli_data.id