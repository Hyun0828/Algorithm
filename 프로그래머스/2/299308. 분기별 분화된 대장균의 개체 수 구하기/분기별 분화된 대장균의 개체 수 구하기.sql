with q1 as (
    select
        '1Q' as quarter,
        count(*) as ecoli_count
    from ecoli_data
    where month(differentiation_date) >= 1 and month(differentiation_date) <= 3
),
q2 as (
    select 
        '2Q' as quarter,
        count(*) as ecoli_count
    from ecoli_data
    where month(differentiation_date) >= 4 and month(differentiation_date) <= 6
),
q3 as (
    select 
        '3Q' as quarter,
        count(*) as ecoli_count
    from ecoli_data
    where month(differentiation_date) >= 7 and month(differentiation_date) <= 9
),
q4 as (
    select 
        '4Q' as quarter,
        count(*) as ecoli_count
    from ecoli_data
    where month(differentiation_date) >= 10 and month(differentiation_date) <= 12
)
select *
from q1 
union all 
select *
from q2
union all
select *
from q3
union all
select *
from q4
