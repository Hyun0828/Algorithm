with t as (
    select emp_no, sum(score) as total
    from hr_grade
    group by emp_no
)
select
    t.total as score,
    e.emp_no,
    e.emp_name,
    e.position,
    e.email
from hr_employees e
join t on e.emp_no = t.emp_no
order by total desc
limit 1
