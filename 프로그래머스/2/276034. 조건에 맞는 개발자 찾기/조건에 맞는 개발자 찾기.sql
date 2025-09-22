with s as (
    select code
    from skillcodes
    where name = 'Python' or name = 'C#'
)
select 
distinct
    d.id,
    d.email,
    d.first_name,
    d.last_name
from developers d join s
where d.skill_code & s.code = s.code
order by d.id