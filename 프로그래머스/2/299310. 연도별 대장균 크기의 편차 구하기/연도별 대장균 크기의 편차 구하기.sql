with t as (
    select max(size_of_colony) as max_size, year(differentiation_date) as year
    from ecoli_data
    group by year(differentiation_date)
)
select
    t.year,
    t.max_size - e.size_of_colony as year_dev,
    e.id
from ecoli_data e
join t on year(e.differentiation_date) = t.year
order by t.year, year_dev
