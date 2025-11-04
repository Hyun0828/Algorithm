select
    e.dept_id,
    h.dept_name_en,
    round(avg(e.sal), 0) as avg_sal
from hr_department h
join hr_employees e on h.dept_id = e.dept_id
group by e.dept_id
order by avg_sal desc