with t as (
    select
        emp_no,
        sum(score) as score
    from hr_grade
    group by emp_no
    order by sum(score) desc
    limit 1
)
select
    t.score,
    e.emp_no,
    e.emp_name,
    e.position,
    e.email
from hr_employees e
join t on t.emp_no = e.emp_no


