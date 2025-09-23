select i.id, t.fish_name, i.length
from fish_info i
join fish_name_info t on i.fish_type = t.fish_type
where i.length = (
    select max(i2.length)
    from fish_info i2
    where i2.fish_type = i.fish_type
)
order by i.id 