with a as (
    select 
        flavor,
        sum(total_order) as total_order
    from first_half
    group by flavor
),
b as (
    select 
        flavor,
        sum(total_order) as total_order
    from july
    group by flavor
),
c as (
    select
        a.flavor,
        a.total_order+b.total_order as total
    from a
    join b on a.flavor = b.flavor
)
select flavor
from c
order by total desc
limit 3