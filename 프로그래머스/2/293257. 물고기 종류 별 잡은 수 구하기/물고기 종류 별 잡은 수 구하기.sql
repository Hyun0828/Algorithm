select
    count(id) as fish_count,
    n.fish_name
from fish_info i
join fish_name_info n on i.fish_type = n.fish_type
group by n.fish_type, n.fish_name
order by fish_count desc