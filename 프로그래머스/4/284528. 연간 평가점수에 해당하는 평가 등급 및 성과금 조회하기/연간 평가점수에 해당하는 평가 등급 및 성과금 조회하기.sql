with g as (
    select
        emp_no,
        avg(score) as total_score,
        case
            when avg(score) >= 96 then 'S'
            when avg(score) >= 90 then 'A'
            when avg(score) >= 80 then 'B'
            else 'C'
        end as grade
    from hr_grade
    group by emp_no
)
select
    e.emp_no,
    e.emp_name,
    g.grade,
    case 
        when g.grade = 'S' then round(e.sal * 0.2, 0)
        when g.grade = 'A' then round(e.sal * 0.15, 0)
        when g.grade = 'B' then round(e.sal * 0.1, 0)
        else 0
    end as bonus
from hr_employees e
join g on e.emp_no = g.emp_no 
order by e.emp_no
