with recursive hierarchy as (
    select id, parent_id, 1 as generation
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, h.generation + 1
    from ecoli_data e
    join hierarchy h on e.parent_id = h.id
)

select count(*) as count, p.generation
from hierarchy p
left join hierarchy c on p.id = c.parent_id
where c.id is null
group by p.generation
order by p.generation
    